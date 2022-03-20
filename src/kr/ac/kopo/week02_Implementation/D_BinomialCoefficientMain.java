package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;

public class D_BinomialCoefficientMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] nums = input.split(" ");
		SolutionD solution = new SolutionD();
		solution.solution(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));

		sc.close();
	}
}

class SolutionD {

	public void solution(int num1, int num2) {
		int[] factorial = new int[num1+1];

		for (int i = 0; i < factorial.length; i++) {
			if (i == 0)
				factorial[0] = 1;
			else
				factorial[i] = factorial[i - 1] * i;
		}
//		System.out.println(Arrays.toString(factorial));
		
		System.out.println(factorial[num1] / (factorial[num1-num2] * factorial[num2]));
	}
}
