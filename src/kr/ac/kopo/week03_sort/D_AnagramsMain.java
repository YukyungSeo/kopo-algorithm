package kr.ac.kopo.week03_sort;

import java.util.Arrays;
import java.util.Scanner;

public class D_AnagramsMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {

			String[] input = sc.nextLine().split(" ");

			// debugging - input
//			for (String str : input) {
//				System.out.print(str + " ");
//			}
//			System.out.println();

			SolutionD solution = new SolutionD();
			solution.solution(input);
		}
		sc.close();
	}
}

class SolutionD {

	public void solution(String[] input) {

		char[] word1 = input[0].toCharArray();
		char[] word2 = input[1].toCharArray();
		
		Arrays.sort(word1);
		Arrays.sort(word2);
		
		String str1 = new String(word1);
		String str2 = new String(word2);

		if (str1.equals(str2))
			System.out.printf("%s & %s are anagrams.\n", input[0], input[1]);
		else
			System.out.printf("%s & %s are NOT anagrams.\n", input[0], input[1]);

	}
}
