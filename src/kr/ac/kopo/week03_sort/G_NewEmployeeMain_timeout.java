//package kr.ac.kopo.week03_sort;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class G_NewEmployeeMain_timeout {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int testcase = Integer.parseInt(sc.nextLine());
//		for (int i = 0; i < testcase; i++) {
//			int num = Integer.parseInt(sc.nextLine());
//
//			Map<Integer, Integer> map = new HashMap<>();
//			for (int j = 0; j < num; j++) {
//				String[] inputStr = sc.nextLine().split(" ");
//				map.put(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1]));
//			}
//
//			// debugging - map
////			Set<Map.Entry<Integer, Integer>> set = map.entrySet(); 
////			for (Entry<Integer, Integer> entry : set) {
////				System.out.print(entry.getKey() + " ");
////			}
//
//			SolutionG solution = new SolutionG();
//			solution.solution(map);
//
//		}
//
//		sc.close();
//	}
//}
//
//class SolutionG {
//	public void solution(Map<Integer, Integer> map) {
//
//		ArrayList<Integer> arr = new ArrayList<>();
//		arr.add(map.get(1));
//		for (int i = 2; i <= map.size(); i++) {
//			int rank = map.get(i);
//			boolean isPass = true;
//
////			System.out.println(i + ", " + rank);
//			for (int j = 0; j < rank && j < arr.size(); j++) {
////				System.out.println("\t" + j + ", " + arr.get(j));
//				if (rank > arr.get(j)) {
//					isPass = false;
//					break;
//				}
//			}
//
//			if (isPass)
//				arr.add(rank);
//		}
//
//		System.out.println(arr.size());
//	}
//}