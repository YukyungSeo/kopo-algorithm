package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;

public class B_FibonacciNumberMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		SolutionB solution = new SolutionB();
		solution.solution(input);

		sc.close();
	}
}

class SolutionB {

	public void solution(int n) {
	
		int[] fibo = new int[n + 1];

		for (int i = 0; i < fibo.length; i++) {
			if (i == 0)
				fibo[0] = 0;
			else if (i == 1)
				fibo[1] = 1;
			else
				fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		System.out.println(fibo[fibo.length - 1]);

	}
}
