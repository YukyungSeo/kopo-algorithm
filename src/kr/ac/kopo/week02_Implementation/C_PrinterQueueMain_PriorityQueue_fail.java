package kr.ac.kopo.week02_Implementation;
//package kr.ac.kopo.week02_Implementation;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class C_PrinterQueue_PriorityQueue_fail {
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int testcase = Integer.parseInt(sc.nextLine());
//		for (int i = 0; i < testcase; i++) {
//			String firstLine = sc.nextLine();
//			String secondLine = sc.nextLine();
//
//			String[] document = firstLine.split(" ");
//			String[] secondLineSplit = secondLine.split(" ");
//			int[] priority = new int[secondLineSplit.length];
//			for (int j = 0; j < priority.length; j++) {
//				priority[j] = Integer.parseInt(secondLineSplit[j]);
//			}
//			SolutionC solution = new SolutionC();
//			solution.solution(Integer.parseInt(document[0]), Integer.parseInt(document[1]), priority);
//		}
//		sc.close();
//	}
//}
//
//class SolutionC {
//
//	public void solution(int docNum, int point, int[] priority) {
//		PriorityQueue<DocInfo> queue = new PriorityQueue<DocInfo>(Collections.reverseOrder());
//
//		System.out.println(Arrays.toString(priority));
//
//		for (int i = 0; i < docNum; i++) {
//			if (i == point)
//				queue.add(new DocInfo(priority[i], i, true));
//			else
//				queue.add(new DocInfo(priority[i], i, false));
//		}
//
//		// debugging - queue
////		for (DocInfo docInfo : queue) {
////		}
//
//		for (int i = 0; i < docNum; i++) {
//			DocInfo docInfo = queue.poll();
//			System.out.println(docInfo.priority + ", " + docInfo.index + ", " + docInfo.isFocus);
//			if (docInfo.isFocus) {
//				System.out.println(i + 1);
////				break;
//			}
//		}
//	}
//
//	class DocInfo implements Comparable<DocInfo> {
//		private int priority;
//		private int index;
//		private boolean isFocus;
//
//		DocInfo(int value, int index, boolean isFocus) {
//			this.priority = value;
//			this.index = index;
//			this.isFocus = isFocus;
//		}
//
//		@Override
//		public int compareTo(DocInfo o) {
//			if (priority > o.priority)
//				return 1;
//			else
//				return index < o.index ? -1 : 1;
//		}
//	}
//}
