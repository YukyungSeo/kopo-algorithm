package kr.ac.kopo.week01_string;

/*
 * 백준 1316번
 * 
 * 문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

 * 입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

 * 출력
첫째 줄에 그룹 단어의 개수를 출력한다.

예제 입력 1 
3
happy
new
year
예제 출력 1 
3

예제 입력 2 
4
aba
abab
abcabc
a
예제 출력 2 
1


처음 나타나는 단어와 계속 비교하다가 다음 덩어리의 단어가 나오면 이전 단어의 배열에 1을 입력한다
새로운 단어를 찾았는데 배열의 값이 1이면 false
 */

import java.util.Scanner;
import java.util.Arrays;

public class C_GroupWordCheckerMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[] S = new String[N];
		for (int i = 0; i < N; i++) {
			S[i] = sc.next();
		}

		int[] alphabets = new int[26];
		int wordCount = 0;
		for (int n = 0; n < N; n++) {
			
			// 첫 알파벳의 배열 증가
			alphabets[S[n].charAt(0)-'a']++;
			
			boolean isGroup = true;
			for (int i = 1; i < S[n].length(); i++) {
				// 알파벳이 달라질 때마다
				if (S[n].charAt(i-1) != S[n].charAt(i))
					// 앞서 나온 알파벳이 아니라면
					if(alphabets[S[n].charAt(i)-'a'] != 0) {
						isGroup = false; // group 단어가 아님
						break;
					}
					// 해당 알파벳의 배열 증가
					alphabets[S[n].charAt(i)-'a']++;
			}
			
			if(isGroup)
				wordCount++;

			Arrays.fill(alphabets, 0);
		}
		System.out.println(wordCount);

		sc.close();
	}
}
