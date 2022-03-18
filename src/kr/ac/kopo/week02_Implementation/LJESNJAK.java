package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;
import java.util.Stack;

public class LJESNJAK {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Solution solution = new Solution();
		solution.solution(input);

		sc.close();
	}
}

class Solution {

	public void solution(String string) {
		char[] alphaEqual = new char[3];
		char[] alphaThree = new char[2];
		char[] alphaMin = new char[2];
		char[] alphaJ = new char[2];

		alphaEqual[0] = 'c';
		alphaEqual[1] = 's';
		alphaEqual[2] = 'z';

		alphaThree[0] = 'd';
		alphaThree[1] = 'z';

		alphaMin[0] = 'c';
		alphaMin[1] = 'd';

		alphaJ[0] = 'l';
		alphaJ[1] = 'n';

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			switch (string.charAt(i)) {
			case '=': {
			}
			case '-':
			case 'j':
			}
		}

	}
}
