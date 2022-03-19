package kr.ac.kopo.week01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/* 백준 5052번
 * 
 * 문제
전화번호 목록이 주어진다. 이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.

전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.

예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자

긴급전화: 911
상근: 97 625 999
선영: 91 12 54 26
이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다. 전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다. 
따라서, 이 목록은 일관성이 없는 목록이다. 

 * 입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (1 ≤ t ≤ 50) 각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다. (1 ≤ n ≤ 10000) 
다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다. 전화번호의 길이는 길어야 10자리이며, 목록에 있는 두 전화번호가 같은 경우는 없다.

 * 출력
각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다.

예제 입력 1 
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346

예제 출력 1 
NO
YES


2
2
911
91125426
3
113
123440
98346
 */
public class G_PhoneListMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int books = sc.nextInt();
		
		ArrayList<ArrayList<String>> phoneList = new ArrayList<ArrayList<String>>();
		
		for (int b = 0; b < books; b++) {
			
			phoneList.add(new ArrayList<String>());
			
			int cnt = sc.nextInt();
			for (int p = 0; p < cnt; p++) {
				String string = sc.next();
				phoneList.get(b).add(string);
			}
		}
		
		// debugging - phoneList 
//		for (ArrayList<String> arrayList : phoneList) {
//			for (String string : arrayList) {
//				System.out.println(string);
//			}
//		}

		boolean[] check = new boolean[books];
		Arrays.fill(check,true);
		
		for (int book = 0; book < books; book++) {
			
			ArrayList<String> phones = phoneList.get(book);
			phones.sort(Comparator.naturalOrder());
			
			// debugging - sorted phones 
//			for (String string : phones) {
//				System.out.println(string);				
//			}
//			System.out.println();
			
			for (int idx = 1; idx < phones.size(); idx++) {
				String p1 = phones.get(idx-1);
				String p2 = phones.get(idx);
				
				int size1 = phones.get(idx-1).length();
				if(size1 <= p2.length() && p1.equals(p2.substring(0, size1))) {
//					System.out.println(p1 + ", " + p2);
					check[book] = false;
					break;
				}
			}
		}
		
		for (boolean b : check) {
			System.out.println(b ? "YES" : "NO");
		}
		
		sc.close();
	}
}
