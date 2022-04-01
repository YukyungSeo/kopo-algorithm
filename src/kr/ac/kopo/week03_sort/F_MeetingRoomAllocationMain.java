package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class F_MeetingRoomAllocationMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());

		ArrayList<Meeting> input = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			String[] inputStr = sc.nextLine().split(" ");
			input.add(new Meeting(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1])));
		}

		// debugging - input
//		System.out.print(input.toString());

		SolutionF solution = new SolutionF();
		solution.solution(input);

		sc.close();
	}
}

class SolutionF {
	public void solution(ArrayList<Meeting> input) {

		input.sort(Comparator.naturalOrder());

		System.out.println(input.toString());

	}
}

class Meeting implements Comparable<Meeting> {
	private int start;
	private int end;

	public Meeting() {
		super();
	}

	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		return this.start - o.start;
	}

	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]\n";
	}

}