package kr.ac.kopo.week03_sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class G_NewEmployeeMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			int num = Integer.parseInt(sc.nextLine());

			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < num; j++) {
				String[] inputStr = sc.nextLine().split(" ");
				map.put(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1]));
			}
			
			// debugging - map
//			Set<Map.Entry<Integer, Integer>> set = map.entrySet(); 
//			for (Entry<Integer, Integer> entry : set) {
//				System.out.print(entry.getKey() + " ");
//			}

			SolutionG solution = new SolutionG();
			solution.solution(map);

		}

		sc.close();
	}
}

class SolutionG {
	public void solution(Map<Integer, Integer> map) {

		Map<Integer, Integer> pass = new HashMap<>();
		pass.put(1, map.get(1));

		for (int i = 2; i <= map.size(); i++){
			int rank = map.get(i);
			Set<Map.Entry<Integer, Integer>> passSet = pass.entrySet();
			boolean isPass = true;
			for (Entry<Integer, Integer> entry : passSet) {
				if (rank > entry.getValue()) {
					isPass = false;
					break;
				}
			}

			if (isPass)
				pass.put(i, rank);
		}

		System.out.println(pass.size());
	}
}