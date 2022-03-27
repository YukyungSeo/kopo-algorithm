//package kr.ac.kopo.week03_sort;
//
//import java.util.ArrayList;
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
//			int[][] inputs = new int[num][2];
//
//			for (int j = 0; j < num; j++) {
//				String[] inputStr = sc.nextLine().split(" ");
//				for (int k = 0; k < inputStr.length; k++) {
//					inputs[j][k] = Integer.parseInt(inputStr[k]);
//				}
//			}
//
//			// debugging - input
////			for (int[] in : inputs) {
////				for (int d : in) {
////					System.out.print(d + " ");
////				}
////				System.out.println();
//
//			SolutionG solution = new SolutionG();
//			solution.solution(inputs);
//
//		}
//
//		sc.close();
//	}
//}
//
//class SolutionG {
//	public void solution(int[][] inputs) {
//
//		// ArrayList에 Interview 형태로 정렬
//		ArrayList<Interviewer> list = new ArrayList<>();
//		for (int[] in : inputs) {
//			list.add(new Interviewer(in[0], in[1]));
//		}
//
//		int cnt = 0;
//		for (int i = 0; i < inputs.length; i++) {
//			Interviewer interviewer = list.get(i);
////			System.out.printf("this : %d, %d\n", interviewer.getPaperExamRank(), interviewer.getInterviewRank());
//			
//			boolean isPass = true;
//			for (int j = 0; j < inputs.length; j++) {
//				Interviewer other = list.get(j);
////				System.out.printf("\tother : %d, %d\n", other.getPaperExamRank(), other.getInterviewRank());
//				
//				// 두 rank 모두 다른 사람의 rank보다 낮을 경우(return false) 더이상 비교할 필요 X
//				if (/* !interviewer.equals(other) && */!interviewer.compareTo(other)) {
//					isPass = false;
//					break;
//				}
//			}
//			
//			if(isPass)
//				cnt++;
//		}
//
//		System.out.println(cnt);
//	}
//}
//
//class Interviewer {
//	private int paperExamRank;
//	private int interviewRank;
//
//	public Interviewer() {
//		super();
//	}
//
//	public Interviewer(int paperExamRank, int interviewRank) {
//		super();
//		this.paperExamRank = paperExamRank;
//		this.interviewRank = interviewRank;
//	}
//
//	public int getPaperExamRank() {
//		return paperExamRank;
//	}
//
//	public void setPaperExamRank(int paperExamRank) {
//		this.paperExamRank = paperExamRank;
//	}
//
//	public int getInterviewRank() {
//		return interviewRank;
//	}
//
//	public void setInterviewRank(int interviewRank) {
//		this.interviewRank = interviewRank;
//	}
//
//	boolean compareTo(Interviewer o /* 다른 사람의 점수 */) {
//		// 두 rank 모두 다른 사람 보다 낮을 경우 false
//		return !(this.paperExamRank > o.paperExamRank && this.interviewRank > o.interviewRank);
//	}
//}