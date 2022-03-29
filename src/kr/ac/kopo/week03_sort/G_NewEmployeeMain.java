package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class G_NewEmployeeMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			int num = Integer.parseInt(sc.nextLine());

			ArrayList<Interviewer> input = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				String[] inputStr = sc.nextLine().split(" ");
				input.add(new Interviewer(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1])));
			}

			// debugging - map
//			Set<Map.Entry<Integer, Integer>> set = map.entrySet(); 
//			for (Entry<Integer, Integer> entry : set) {
//				System.out.print(entry.getKey() + " ");
//			}

			SolutionG solution = new SolutionG();
			solution.solution(input);

		}

		sc.close();
	}
}

class SolutionG {
	public void solution(ArrayList<Interviewer> input) {

		input.sort(Comparator.naturalOrder());

		ArrayList<Integer> arr = new ArrayList<>();

		int rank = input.get(0).getInterviewRank();
		arr.add(input.get(0).getInterviewRank());

		for (int i = 1; i < input.size(); i++) {
			int interviewRank = input.get(i).getInterviewRank();
			if (interviewRank < rank && arr.get(arr.size() - 1) > interviewRank)
				arr.add(interviewRank);
		}

		// debugging - arr
//		System.out.println(arr.toString());

		System.out.println(arr.size());
	}
}

class Interviewer implements Comparable<Interviewer> {
	private int paperExamRank;
	private int interviewRank;

	public Interviewer() {
		super();
	}

	public Interviewer(int paperExamRank, int interviewRank) {
		super();
		this.paperExamRank = paperExamRank;
		this.interviewRank = interviewRank;
	}

	public int getPaperExamRank() {
		return paperExamRank;
	}

	public void setPaperExamRank(int paperExamRank) {
		this.paperExamRank = paperExamRank;
	}

	public int getInterviewRank() {
		return interviewRank;
	}

	public void setInterviewRank(int interviewRank) {
		this.interviewRank = interviewRank;
	}

	public int compareTo(Interviewer o) {
		return this.paperExamRank - o.paperExamRank;
	}

	@Override
	public String toString() {
		return "Interviewer [paperExamRank=" + paperExamRank + ", interviewRank=" + interviewRank + "]\n";
	}

}