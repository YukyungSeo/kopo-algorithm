package kr.ac.kopo.week03_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class H_TwoSolutionsMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());

		ArrayList<Element> arr = new ArrayList<>();
		String[] inputStr = sc.nextLine().split(" ");
		for (int i = 0; i < num; i++) {
			int v = Integer.parseInt(inputStr[i]);
			arr.add(new Element(Math.abs(v), v));
		}

		// debugging - arr
//		for (Element a : arr) {
//			System.out.print(a.getRealValue() + " ");
//		}

		SolutionH solution = new SolutionH();
		solution.solution(arr);

		sc.close();
	}
}

class SolutionH {
	public void solution(ArrayList<Element> input) {

		input.sort(Comparator.naturalOrder());

		// debugging - input
//		for (Element e : input) {
//			System.out.print(e.getRealValue() + " ");
//		}

		ArrayList<Node> arr = new ArrayList<Node>();
		for (int i = 1; i < input.size(); i++) {
			int x = input.get(i - 1).getRealValue();
			int y = input.get(i).getRealValue();
			int gap = Math.abs(x + y);

			arr.add(new Node(gap, x, y));
		}

		arr.sort(Comparator.naturalOrder());
		int x = arr.get(0).getX();
		int y = arr.get(0).getY();
		System.out.println(x < y ? x + " " + y : y + " " + x);
	}
}

class Element implements Comparable<Element> {
	private int absValue;
	private int realValue;

	public Element() {
		super();
	}

	public Element(int absValue, int realValue) {
		super();
		this.absValue = absValue;
		this.realValue = realValue;
	}

	public int getAbsValue() {
		return absValue;
	}

	public void setAbsValue(int absValue) {
		this.absValue = absValue;
	}

	public int getRealValue() {
		return realValue;
	}

	public void setRealValue(int realValue) {
		this.realValue = realValue;
	}

	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return this.absValue - o.absValue;
	}

	@Override
	public String toString() {
		return "Element [absValue=" + absValue + ", realValue=" + realValue + "]";
	}

}

class Node implements Comparable<Node> {
	private int gap;
	private int x;
	private int y;

	public Node(int gap, int x, int y) {
		super();
		this.gap = gap;
		this.x = x;
		this.y = y;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		return this.gap - o.gap;
	}

	@Override
	public String toString() {
		return "Node [gap=" + gap + ", x=" + x + ", y=" + y + "]";
	}

}