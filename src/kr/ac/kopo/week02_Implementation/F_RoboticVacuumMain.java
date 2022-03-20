package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * 0. 청소
 * 1. 자신의 위치에서 동서남북 청소할 곳이 있는지 확인 : (지도 내부 && 벽 X && 청소 X)
 * 2-1. 있으면 이동 -> 1.
 * 2-2. 없으면 뒤에 벽인지 확인 (지도 내부 && 벽 X) - 청소는 되어 있을 것임 (1번 할 때 같이 check하면 될 것 같은데)
 * 3-1. 벽 아니면, 뒤로 후진 1칸 -> 1.
 * 3-2. 벽이면, break;
 * 
 */

/*
3 3
1 1 0
0 0 0
0 0 0
0 0 0

9

4 4
1 1 0
0 1 0 0
0 0 0 0
0 0 1 0
0 0 0 0

12

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57
 */

public class F_RoboticVacuumMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();

		String[] mapSize = firstLine.split(" ");
		String[] robot = secondLine.split(" ");

		int mapRowSize = Integer.parseInt(mapSize[0]);
		int mapColSize = Integer.parseInt(mapSize[1]);

		int row = Integer.parseInt(robot[0]);
		int col = Integer.parseInt(robot[1]);
		int dir = Integer.parseInt(robot[2]);

		int[][] map = new int[mapRowSize][mapColSize];
		for (int i = 0; i < mapRowSize; i++) {
			String line = sc.nextLine();
			String[] values = line.split(" ");
			for (int j = 0; j < mapColSize; j++) {
				map[i][j] = Integer.parseInt(values[j]);
			}
		}

		// debugging - map
//		System.out.println("< map >");
//		for (int[] is : map) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		SolutionF solution = new SolutionF();
		solution.solution(mapRowSize, mapColSize, row, col, dir, map);
		sc.close();
	}
}

class SolutionF {

	void solution(int mapRowSize, int mapColSize, int row, int col, int initialDir, int[][] map) {
		Robot robot = new Robot(new Point(row, col), initialDir);
		Space space = new Space(map, mapRowSize, mapColSize);

		while (true) {
//		int num = 0;
//		while (num < 5) {
//			num++;
//			System.out.println("---------------");

			space.clean(robot.point.row, robot.point.col);

//			// debugging - map
//			System.out.println("< map >");
//			for (int[] is : space.map) {
//				for (int i : is) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}
//			// debugging - cleanMap
//			System.out.println("< cleanMap >");
//			for (int[] is : space.cleanMap) {
//				for (int i : is) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}

			Space.FourDirectionsCondition condition = space.new FourDirectionsCondition();
			condition.fill(robot.point);

			int newDir = space.findDirty(condition, robot.dir);
			
//			System.out.print("이전 robot 위치 : " + robot.point.row + ", " + robot.point.col + "  ");
//			System.out.println("robot 방향 : " + robot.dir);
//			System.out.println("청소할 공간 방향 : " + newDir);
			
			if (newDir != -1) {

				robot.move(newDir);
				robot.dir = newDir;
			} else {
//				System.out.println("청소할 공간 없음");
				int behindDir = (robot.dir + 2) % 4;
				if (space.isWallBehind(condition, behindDir)) {
//					System.out.println("뒤로 후진");
					robot.move(behindDir);
				} else {
//					System.out.println("청소 종료");
					break;
				}
			}

//			System.out.print("현재 robot 위치 : " + robot.point.row + ", " + robot.point.col + "  ");
//			System.out.println("robot 방향 : " + robot.dir);
		}

		int sum = 0;
		for (int[] js : space.cleanMap) {
			sum += IntStream.of(js).sum();
		}
		System.out.println(sum);
	}

	class Robot {
		Point point;
		int dir;

		public Robot(Point point, int dir) {
			this.point = point;
			this.dir = dir;
		}

		boolean move(int newDir) {
			switch (newDir) {
			case 0: // 북
				this.point.row--;
				break;
			case 1: // 동
				this.point.col++;
				break;
			case 2: // 남
				this.point.row++;
				break;
			case 3: // 서
				this.point.col--;
				break;
			}
			return true;
		}
	}

	class Space {
		int[][] map;
		int[][] cleanMap;
		int rowSize;
		int colSize;

		public Space(int[][] map, int mapRowSize, int mapColSize) {
			this.map = map;
			this.rowSize = mapRowSize;
			this.colSize = mapColSize;
			this.cleanMap = new int[this.rowSize][this.colSize];
		}

		public boolean isWallBehind(FourDirectionsCondition condition, int behindDir) {
			if (!condition.outMap[behindDir] && !condition.isWall[behindDir])
				return true;
			return false;
		}

		int findDirty(FourDirectionsCondition condition, int dir) {
			dir = (dir + 3) % 4;
			boolean find = false;
			int searchDir = dir;
			for (int i = 0; i < 4; i++) {
				searchDir = (dir + 4 - i) % 4;
//				System.out.print("dir : " + searchDir + "\t");
				if (!condition.outMap[searchDir] && !condition.isClean[searchDir] && !condition.isWall[searchDir]) {
					find = true;
					break;
				}
			}
//			System.out.println();
			if (find)
				return searchDir;
			return -1;
		}

		void clean(int row, int col) {
			if (this.cleanMap[row][col] == 0)
				this.cleanMap[row][col] = 1;
		}

		class FourDirectionsCondition {
			// 0인 경우에는 북쪽
			// 1인 경우에는 동쪽
			// 2인 경우에는 남쪽
			// 3인 경우에는 서쪽
			boolean[] outMap;
			boolean[] isClean;
			boolean[] isWall;

			FourDirectionsCondition() {
				this.outMap = new boolean[4];
				this.isClean = new boolean[4];
				this.isWall = new boolean[4];
			}

			void fill(Point point) {
				int prow = point.row;
				int pcol = point.col;

				// inMap
				if (prow - 1 < 0)
					outMap[0] = true;
				if (prow > rowSize - 2)
					outMap[2] = true;
				if (pcol - 1 < 0)
					outMap[3] = true;
				if (pcol > colSize - 2)
					outMap[1] = true;

				// isClean && isWall
				if (!outMap[0]) {
					if (cleanMap[prow - 1][pcol] == 1)
						isClean[0] = true;
					if (map[prow - 1][pcol] == 1)
						isWall[0] = true;
				}
				if (!outMap[2]) {
					if (cleanMap[prow + 1][pcol] == 1)
						isClean[2] = true;
					if (map[prow + 1][pcol] == 1)
						isWall[2] = true;
				}
				if (!outMap[3]) {
					if (cleanMap[prow][pcol - 1] == 1)
						isClean[3] = true;
					if (map[prow][pcol - 1] == 1)
						isWall[3] = true;
				}
				if (!outMap[1]) {
					if (cleanMap[prow][pcol + 1] == 1)
						isClean[1] = true;
					if (map[prow][pcol + 1] == 1)
						isWall[1] = true;
				}

				// debugging - outMap, isClean, isWall
//				System.out.println("outMap : " + Arrays.toString(outMap));
//				System.out.println("isClean : " + Arrays.toString(isClean));
//				System.out.println("isWall : " + Arrays.toString(isWall));
			}
		}

	}

	class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}