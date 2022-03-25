package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B_SortNumberMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int[] inputs = new int[num];
		for (int i = 0; i < num; i++) {
			inputs[i] = Integer.parseInt(sc.nextLine());
		}
		SolutionB solution = new SolutionB();
		solution.solution(inputs);
		sc.close();
	}
}

class SolutionB {
	public void solution(int[] inputs) {

		ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(inputs).boxed().collect(Collectors.toList());

		arr.sort(Comparator.naturalOrder());

		for (int ar : arr) {
			System.out.println(ar);
		}

	}
}
