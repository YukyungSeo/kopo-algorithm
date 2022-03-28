//package kr.ac.kopo.week03_sort;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Scanner;
//
//// - -> + 정렬
//// 하나씩 더하다가 줄어들던 절대값이 커지면 저장 & break
//// 저장된 값중 절댓값이 제일 작은 값 정보 반환
//public class H_TwoSolutionsMain_timeout {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int num = Integer.parseInt(sc.nextLine());
//
//		ArrayList<Integer> arr = new ArrayList<>();
//		String[] inputStr = sc.nextLine().split(" ");
//		for (int i = 0; i < num; i++) {
//			arr.add(Integer.parseInt(inputStr[i]));
//		}
//
//		// debugging - arr
////		for (int a : arr) {
////			System.out.print(a + " ");
////		}
//
//		SolutionH solution = new SolutionH();
//		solution.solution(arr);
//
//		sc.close();
//	}
//}
//
//class SolutionH {
//	public void solution(ArrayList<Integer> input) {
//
//		input.sort(Comparator.naturalOrder());
//
//		// debugging - input
////		System.out.println(input.toString());
//
//		ArrayList<Node> arr = new ArrayList<Node>();
//		for (int i = 0; i < input.size()-1; i++) {
//			int x = input.get(i);
//			int gap = Integer.MAX_VALUE;
//			Node newNode = new Node(gap, -1, -1);
//
//			for (int j = i + 1; j < input.size(); j++) {
//				int y = input.get(j);
//				int newGap = Math.abs(x + y);
////				System.out.printf("gap : %3d\t x : %3d\t y : %3d\n", newGap, input.get(i), input.get(j));
//				
//				if (gap > newGap) {
//					gap = newGap;
//					newNode.setGap(gap);
//					newNode.setX(x);
//					newNode.setY(y);
//				} else {
//					break;
//				}
//			}
//
//			arr.add(newNode);
//		}
//
//		// debugging - arr
////		for (Node node : arr) {
////			System.out.println(node.toString());
////		}
//
//		arr.sort(Comparator.naturalOrder());
//		System.out.println(arr.get(0).getX() + " " + arr.get(0).getY());
//	}
//}
//
//class Node implements Comparable<Node> {
//	private int gap;
//	private int x;
//	private int y;
//
//	public Node(int gap, int x, int y) {
//		super();
//		this.gap = gap;
//		this.x = x;
//		this.y = y;
//	}
//
//	public int getGap() {
//		return gap;
//	}
//
//	public void setGap(int gap) {
//		this.gap = gap;
//	}
//
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	@Override
//	public int compareTo(Node o) {
//		return this.gap - o.gap;
//	}
//
//	@Override
//	public String toString() {
//		return "Node [gap=" + gap + ", x=" + x + ", y=" + y + "]";
//	}
//
//}