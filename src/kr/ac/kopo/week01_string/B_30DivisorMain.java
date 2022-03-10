package kr.ac.kopo.week01_string;

/*
 * 백준 10610번
 * 
 * 문제
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 
미르코는 30이란 수를 존경하기 때문에, 
그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

 * 입력
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

 * 출력
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율


예제 입력 1 
30
예제 출력 1 
30

예제 입력 2 
102
예제 출력 2 
210

예제 입력 3 
2931
예제 출력 3 
-1

예제 입력 4 
80875542
예제 출력 4 
88755420

0없으면 바로 아웃 
나머지 3의 배열 확인하는 방법(모든 값들의 합이 3의 배수)으로 만들기
 */

import java.util.Arrays;
import java.util.Scanner;

public class B_30DivisorMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		int[] nums = new int[N.length()];
		int sum = 0;
		boolean noZero = true;
		
		for(int i=0; i<N.length(); i++) {
			nums[i] = N.charAt(i)-48;
//			System.out.println(nums[i]);
			
			if(nums[i] == 0)
				noZero = false;
			
			sum+=nums[i];
		}
		
//		System.out.println("noZero : " + noZero);
//		System.out.println("sum : " + sum);
		
		if(!noZero) {
			if(sum%3 != 0) 
				System.out.println(-1);
			else {
				Arrays.sort(nums);
				for(int i=nums.length-1; i>=0; i--)
					System.out.print(nums[i]);
			}
		} else {
			System.out.println(-1);
		}

		sc.close();
	}
}
