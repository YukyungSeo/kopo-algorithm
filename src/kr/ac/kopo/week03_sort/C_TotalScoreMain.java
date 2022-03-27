package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C_TotalScoreMain {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			int[] input = new int[5];

			String[] inputStr = sc.nextLine().split(" ");
			for (int j = 0; j < inputStr.length; j++)
				input[j] = Integer.parseInt(inputStr[j]);

			// debugging - input
//			for (int in : input) {
//				System.out.print(in + " ");
//			}
//			System.out.println();

			SolutionC solution = new SolutionC();
			solution.solution(input);
		}
		sc.close();
	}
}

class SolutionC {

	public void solution(int[] input) {

		ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(input).boxed().collect(Collectors.toList());
		arr.sort(Comparator.naturalOrder());
		arr.remove(arr.size() - 1);
		arr.remove(0);

		if (arr.get(arr.size() -1) - arr.get(0) >= 4)
			System.out.println("KIN");
		else
			System.out.println(arr.stream().mapToInt(Integer::intValue).sum());

	}
	
}
