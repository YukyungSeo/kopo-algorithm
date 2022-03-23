package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;

/*

3 3
1 2 3
5 4 3
2 3 4

16

3 5
5 1 1 1 1
5 5 1 1 1
5 1 1 1 1

20

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

	private int[][] map;

	void solution(int[][] map) {

		this.map = map;

		// 각 max 값을 찾아 넣는다.
		int max = 0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				int tmp = otherTetro(row, col, 4, ' ');
				if (max < tmp)
					max = tmp;
//				System.out.print(tmp + " ");
			}
//			System.out.println();
		}

		for (int row = 0; row < map.length - 1; row++) {
			for (int col = 0; col < map[row].length - 1; col++) {
				int tmp = threeWayTetro(row, col);
				if (max < tmp)
					max = tmp;
//				System.out.print(tmp + " ");
			}
//			System.out.println();
		}

//		max = stepByStepTetro(1, 0, 4, ' ');
//		max = threeWayTetro(1, 1);

		System.out.println(max);
	}

	private int threeWayTetro(int row, int col) {
		int m0 = 0, m1 = 0, m2 = 0, m3 = 0;

		if (row > 0)
			m0 = this.map[row - 1][col];
		if (row < map.length - 1)
			m1 = this.map[row + 1][col];
		if (col > 0)
			m2 = this.map[row][col - 1];
		if (col < map[row].length - 1)
			m3 = this.map[row][col + 1];

		int min0 = m0 < m1 ? m0 : m1;
		int min1 = m2 < m3 ? m2 : m3;

		int min = min0 < min1 ? min0 : min1;

		return this.map[row][col] + m0 + m1 + m2 + m3 - min;
	}

	private int otherTetro(int row, int col, int num, char dir) {

		if (num == 0)
			return 0;
		else {
			int m0 = 0, m1 = 0, m2 = 0, m3 = 0;

			if (dir != '북' && row > 0)
				m0 = otherTetro(row - 1, col, num - 1, '남'); // 북
			if (dir != '남' && row < map.length - 1)
				m1 = otherTetro(row + 1, col, num - 1, '북'); // 남
			if (dir != '서' && col > 0)
				m2 = otherTetro(row, col - 1, num - 1, '동'); // 서
			if (dir != '동' && col < map[row].length - 1)
				m3 = otherTetro(row, col + 1, num - 1, '서'); // 동

			int max01 = m0 > m1 ? m0 : m1;
			int max02 = m2 > m3 ? m2 : m3;

			int max = (max01 > max02 ? max01 : max02) + map[row][col];

//			if (num == 2)
//				System.out.printf("num : %d, row : %d, col : %d, max : %d\n", num, row, col, max);

			return max;
		}
	}

}
