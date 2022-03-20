package kr.ac.kopo.week02_Implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C_PrinterQueueMain_Queue {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			String firstLine = sc.nextLine();
			String secondLine = sc.nextLine();

			String[] document = firstLine.split(" ");
			String[] secondLineSplit = secondLine.split(" ");
			int[] priority = new int[secondLineSplit.length];
			for (int j = 0; j < priority.length; j++) {
				priority[j] = Integer.parseInt(secondLineSplit[j]);
			}
			SolutionC solution = new SolutionC();
			solution.solution(Integer.parseInt(document[0]), Integer.parseInt(document[1]), priority);
		}
		sc.close();
	}
}

class SolutionC {

	public void solution(int docNum, int point, int[] priority) {
		Queue<DocInfo> queue = new LinkedList<DocInfo>();

//		System.out.println(Arrays.toString(priority));

		for (int i = 0; i < docNum; i++) {
			if (i == point)
				queue.add(new DocInfo(priority[i], true));
			else
				queue.add(new DocInfo(priority[i], false));
		}

		int print = 0;
		while (queue.size() != 0) {
			DocInfo docInfo = queue.poll();
//			System.out.println(docInfo.priority + ", " + docInfo.isFocus);
			boolean isHighest = true;
			for (DocInfo docInQueue : queue) {
				if (docInQueue.compareTo(docInfo)) {
//					System.out.println("우선순위가 높은 것이 있다");
					queue.add(docInfo);
					isHighest = false;
					break;
				}
			}
			if (isHighest) {
				print++;
				if (docInfo.isFocus) {
					System.out.println(print);
					break;
				}
			}
		}
	}

	class DocInfo {
		private int priority;
		private boolean isFocus;

		DocInfo(int value, boolean isFocus) {
			this.priority = value;
			this.isFocus = isFocus;
		}

		public boolean compareTo(DocInfo o) {
			return priority > o.priority ? true : false;
		}
	}
}
