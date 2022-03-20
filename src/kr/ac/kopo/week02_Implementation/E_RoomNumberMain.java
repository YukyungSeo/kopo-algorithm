package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;

public class E_RoomNumberMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		SolutionE solution = new SolutionE();
		solution.solution(Integer.parseInt(input));

		sc.close();
	}
}

class SolutionE {

	public void solution(int roomNum) {
		int[] numTable = new int[9];

		while (roomNum > 0) {
			int point = roomNum % 10;
//			System.out.println("point : " + point);

			if (point == 9)
				numTable[6]++;
			else
				numTable[point]++;
			roomNum /= 10;
		}
		numTable[6] = numTable[6] % 2 == 0 ? numTable[6] / 2 : numTable[6] / 2 + 1;

//		System.out.println(Arrays.toString(numTable));
		System.out.println(max(numTable));
	}

	private int max(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i])
				max = array[i];
		}
		return max;
	}
}
