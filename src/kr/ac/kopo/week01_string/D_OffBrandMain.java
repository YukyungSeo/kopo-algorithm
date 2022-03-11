package kr.ac.kopo.week01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 백준 1764번
 * 
 * 문제
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

 * 입력
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

 * 출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.


예제 입력 1 
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton

예제 출력 1 
2
baesangwook
ohhenrie


중복이 없다는건 듣보잡인 문자는 확인시 배열에서 제외시켜서 비교할 일을 줄이는 것이 좋다

 */

import java.util.Scanner;
import java.util.TreeSet;

public class D_OffBrandMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

//		System.out.println(N + ", " + M);
		
		TreeSet<String> namesN = new TreeSet<String>();
		for (int i = 0; i < N; i++) {
			namesN.add(sc.next());
		}
		
		String[] namesM = new String[M];
		for (int i = 0; i < M; i++) {
			namesM[i] = sc.next();
		}
		
		// namesN 출력
//		Iterator<String> iter = namesN.iterator();
//		while(iter.hasNext()) {
//		    System.out.println(iter.next());
//		}
		

		Arrays.sort(namesM);
		
		int count = 0;
		List<String> offHands = new ArrayList<String>();
		for (int m = 0; m < namesM.length; m++) {
			
			String mp = namesM[m];
//			System.out.println(mp);
			if (namesN.contains(mp)) {
				offHands.add(mp);
				count++;
			}
		}
		
		System.out.println(count);
		for (int i = 0; i < offHands.size(); i++)
			System.out.println(offHands.get(i));

		sc.close();
	}
}
