package kr.ac.kopo.week01_string;

//package week01_문자열.G_전화번호_목록;

import java.util.*;

/**
 * Created by soomin on 2022/03/10
 */

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			String[] phoneBook = new String[n];
			for (int j = 0; j < phoneBook.length; j++) {
				phoneBook[j] = scanner.next();
			}
			SolutionT solution = new SolutionT();
			solution.solution(phoneBook);
		}
		
		scanner.close();
	}
}

class SolutionT {
	public void solution(String[] phoneBook) {
		if (phoneBook.length <= 1) {
			System.out.println("YES");
			return;
		}
		ArrayList<String> arrayList = new ArrayList<>();
		Collections.addAll(arrayList, phoneBook);
		Collections.sort(arrayList);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			if (arrayList.get(i + 1).startsWith(arrayList.get(i))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
