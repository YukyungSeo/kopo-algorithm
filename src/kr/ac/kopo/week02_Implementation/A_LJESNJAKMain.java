package kr.ac.kopo.week02_Implementation;

import java.util.Scanner;
import java.util.Stack;

public class A_LJESNJAKMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		SolutionA solution = new SolutionA();
		solution.solution(input);

		sc.close();
	}
}

class SolutionA {

	public void solution(String string) {
		char[] alphaEqual = new char[3];
		char alphaThree;
		char[] alphaMin = new char[2];
		char[] alphaJ = new char[2];

		alphaEqual[0] = 'c';
		alphaEqual[1] = 's';
		alphaEqual[2] = 'z';

		alphaThree = 'd';

		alphaMin[0] = 'c';
		alphaMin[1] = 'd';

		alphaJ[0] = 'l';
		alphaJ[1] = 'n';

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			char point = string.charAt(i);
			if (stack.size() < 1)
				stack.push(point);
			else {
				switch (point) {
				case '=': {
					if (stack.get(stack.size() - 1) == alphaEqual[2]) {
						if (stack.size() > 1 && stack.get(stack.size() - 2) == alphaThree) {
							// 3자리 알파벳, dz=
							stackwork(stack, 3);
							break;
						}
						// 2자리 알파벳, z=
						stackwork(stack, 2);
						break;
					}
					// 2자리 알파벳, c=, s=
					if (stack.get(stack.size() - 1) == alphaEqual[0] || stack.get(stack.size() - 1) == alphaEqual[1]) {
						stackwork(stack, 2);
						break;
					}
				}
				case '-': {
					// 2자리 알파벳, c-, d-
					if (stack.get(stack.size() - 1) == alphaMin[0] || stack.get(stack.size() - 1) == alphaMin[1]) {
						stackwork(stack, 2);
						break;
					}
				}
				case 'j': {
					// 2자리 알파벳, lj, nj
					if (stack.get(stack.size() - 1) == alphaJ[0] || stack.get(stack.size() - 1) == alphaJ[1]) {
						stackwork(stack, 2);
						break;
					}
				}
				default:
					stack.push(point);
				}
			}
//			System.out.println(Arrays.toString(stack.toArray()));
		}

		System.out.println(stack.size());

	}

	private void stackwork(Stack<Character> stack, int alphaSize) {
		for (int i = 0; i < alphaSize-1; i++) {
			stack.pop();
		}
		stack.push('*');
	}
}
