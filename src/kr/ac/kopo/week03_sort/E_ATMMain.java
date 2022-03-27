package kr.ac.kopo.week03_sort;

import java.util.Arrays;
import java.util.Scanner;

public class E_ATMMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int[] inputs = new int[num];

		String[] inputStr = sc.nextLine().split(" ");
		for (int j = 0; j < inputStr.length; j++) {
			inputs[j] = Integer.parseInt(inputStr[j]);
		}

		// debugging - input
//		for (int in : inputs) {
//			System.out.print(in + " ");
//		}
//		System.out.println();

		SolutionE solution = new SolutionE();
		solution.solution(inputs);

		sc.close();
	}
}

class SolutionE {
	public void solution(int[] inputs) {

		Arrays.sort(inputs);

//		System.out.println(Arrays.toString(inputs));

		int[] table = new int[inputs.length];
		int sum = table[0] = inputs[0];

		for (int i = 1; i < table.length; i++) {
			table[i] = table[i - 1] + inputs[i];
			sum += table[i];
		}

//		System.out.println(Arrays.toString(table));

		System.out.println(sum);
	}
}
