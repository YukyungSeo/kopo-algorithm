package kr.ac.kopo.week01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 백준 9935번
 * 
 * 문제
	상근이는 문자열에 폭발 문자열을 심어 놓았다. 
	폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
	
	폭발은 다음과 같은 과정으로 진행된다.
	
	문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 
	남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
	새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
	폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
	상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 
	남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.
	
	폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.

 * 입력
	첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.
	
	둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.
	
	두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.

 * 출력
	첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.

예제 입력 1 
mir4kovC4nizCC44
C4

예제 출력 1 
mir4kovniz

예제 입력 2 
12ab112ab2ab
12ab

b12ab112ab2ab
12ab

b12ab112ab2bb
12ab

예제 출력 2 
FRULA

 */
public class F_ExplosionStringMain {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer string = new StringBuffer(br.readLine());
		String explotion = br.readLine();

		Stack<Character> stack = new Stack<Character>();
		int expLength = explotion.length();
		char lastChar = explotion.charAt(expLength - 1);

		for (int i = 0; i < string.length(); i++) {

			stack.push(string.charAt(i));
			if (stack.peek() == lastChar && stack.size() >= expLength) {

				boolean bool = true;
				for (int j = 1; j < expLength; j++) {
//					System.out.println("stack element : " + stack.get(stack.size()-1-j));
//					System.out.println("explotion ele : " + explotion.charAt(expLength-1-j));
					if(stack.get(stack.size()-1-j) != explotion.charAt(expLength-1-j)) {
						bool = false;
						break;
					}
				}
				if(bool == true) {
					for (int j = 0; j < expLength; j++) {
						stack.pop();
					}
				}
			}

//			System.out.println(stack.toString());
		}

		StringBuffer str = new StringBuffer();
		for (Character character : stack) {
			str.append(character);
		}

		if (str.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(str);

		br.close();
	}
}
