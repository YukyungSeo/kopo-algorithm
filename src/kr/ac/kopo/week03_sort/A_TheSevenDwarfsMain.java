package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A_TheSevenDwarfsMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] dwarfs = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(sc.nextLine());
		}
		SolutionA solution = new SolutionA();
		solution.solution(dwarfs);
		sc.close();
	}
}

class SolutionA {
	public void solution(int[] dwarfs) {

		ArrayList<Integer> dwarfsArr = (ArrayList<Integer>) Arrays.stream(dwarfs).boxed().collect(Collectors.toList());

		dwarfsArr.sort(Comparator.naturalOrder());
		int sum = dwarfsArr.stream().reduce(0, (a, b) -> a + b);
		int differ = sum - 100;

		loop: for (int i = 0; i < dwarfsArr.size(); i++) {
			int guest1 = dwarfsArr.get(i);
			if (guest1 > differ)
				break;
			for (int j = i + 1; j < dwarfsArr.size(); j++) {
				int guest2 = dwarfsArr.get(j);
				if (guest2 > differ)
					break;
				if (guest1 + guest2 == differ) {
					dwarfsArr.remove(j);
					dwarfsArr.remove(i);
					break loop;
				}
			}
		}

		for (int dw : dwarfsArr) {
			System.out.println(dw);
		}

	}
}