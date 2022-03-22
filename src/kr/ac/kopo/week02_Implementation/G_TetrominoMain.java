package kr.ac.kopo.week02_Implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 1. roots의 node들 내에서 현재 node와 근처에 있는 node들 가져오기
// 2. 근처에 있는 node들에게 현재 node를 자식으로 추가하기
// 3. root에 연결된 node 개수가 4인지 확인
// 4. 4개가 있으면 그 중에서 가장 큰 값이 정답 ->  반환

/*

3 3
1 2 3
5 4 3
2 3 4

 */
public class G_TetrominoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();

		String[] mapSize = firstLine.split(" ");

		int mapRowSize = Integer.parseInt(mapSize[0]);
		int mapColSize = Integer.parseInt(mapSize[1]);

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

		SolutionG solution = new SolutionG();
		solution.solution(map);
		sc.close();
	}
}

class SolutionG {
	
	int[][] map;

	void solution(int[][] map) {

		this.map = map;
		
		// 각 max 값을 찾아 넣는다.
		ArrayList<Integer> max = new ArrayList<Integer>();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				max.add(tetro(x, y));
			}
		}
	}

	private int tetro(int x, int y) {
		
		ArrayList<Point> list = this.returnMaxDir(x, y);
		return y;
	}

	private ArrayList<Point> returnMaxDir(int x, int y) {
		ArrayList<Point> list = new ArrayList<Point>();
		int max = this.map[x][y];
		
		
		if(this.map[x-1][y] == this.map[x+1][y]) {
			list.add(new Point(x-1, y));
			list.add(new Point(x+1, y));
		} else {
			list.add(this.map[x-1][y] > this.map[x+1][y] ? new Point(x-1, y) : new Point(x+1, y));
		}
		
		if(this.map[x][y-1] == this.map[x][y+1]) {
			list.add(new Point(x, y-1));
			list.add(new Point(x, y+1));
		} else {
			list.add(this.map[x][y-1] > this.map[x][y+1] ? new Point(x, y-1) : new Point(x, y-1));
		}
		
		
		return null;
	}
	
	
}

class Point {
	int x;
	int y;
	int value;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
