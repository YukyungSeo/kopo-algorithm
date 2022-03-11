package kr.ac.kopo.week01_string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 백준 11656번
 * 
 * 문제
접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 
이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.

 * 입력
첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.

 * 출력
첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.

예제 입력 1 
baekjoon

예제 출력 1 
aekjoon
baekjoon
ekjoon
joon
kjoon
n
on
oon


 */

public class E_SuffixArrayMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		List<String> suffix = new ArrayList<String>();
		for (int i = 0; i < S.length(); i++) {
			suffix.add(S.substring(i));
//			System.out.println(S.substring(i));
		}
		
		suffix.sort(Comparator.naturalOrder());
		for (String string : suffix) {
			System.out.println(string);
		}
		
		sc.close();
	}
}
