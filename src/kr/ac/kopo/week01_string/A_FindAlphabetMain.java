package kr.ac.kopo.week01_string;

/*
 * 백준 10809
 * 
 * 문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 
각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

 * 입력
첫째 줄에 단어 S가 주어진다. 
단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

 * 출력
각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, 
... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.

만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 
단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.

 * 예제 입력
baekjoon

 * 예제 출력
1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

 * 메모
a가 97인것을 생각하여 입력한 S가 a가 나올 경우 97-97을 통해 배열에 접근 
맨처음 초기화 -1로 해주고 처음 등장해야하는 위치여야하므로 내부의 값이 -1인지 확인필요
 * 
 */

import java.util.Scanner;
import java.util.Arrays;

public class A_FindAlphabetMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("단어를 입력하세요 : ");
		String S = sc.next();
		
		int[] alphabets = new int[26];
		Arrays.fill(alphabets, -1);
		
		for (int i = 0; i < S.length(); i++) {
			if(alphabets[S.charAt(i)-97] == -1)
				alphabets[S.charAt(i)-97] = i;
        }
		
		for (int i = 0; i < alphabets.length; i++) {
            System.out.println(alphabets[i]);
        }
		
		sc.close();
	}
}
