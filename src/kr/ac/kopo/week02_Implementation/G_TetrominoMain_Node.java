//package kr.ac.kopo.week02_Implementation;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Scanner;
//
//// 1. roots의 node들 내에서 현재 node와 근처에 있는 node들 가져오기
//// 2. 근처에 있는 node들에게 현재 node를 자식으로 추가하기
//// 3. root에 연결된 node 개수가 4인지 확인
//// 4. 4개가 있으면 그 중에서 가장 큰 값이 정답 ->  반환
//
//public class G_TetrominoMain_Node {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		String firstLine = sc.nextLine();
//
//		String[] mapSize = firstLine.split(" ");
//
//		int mapRowSize = Integer.parseInt(mapSize[0]);
//		int mapColSize = Integer.parseInt(mapSize[1]);
//
//		int[][] map = new int[mapRowSize][mapColSize];
//		for (int i = 0; i < mapRowSize; i++) {
//			String line = sc.nextLine();
//			String[] values = line.split(" ");
//			for (int j = 0; j < mapColSize; j++) {
//				map[i][j] = Integer.parseInt(values[j]);
//			}
//		}
//
//		// debugging - map
////		System.out.println("< map >");
////		for (int[] is : map) {
////			for (int i : is) {
////				System.out.print(i + " ");
////			}
////			System.out.println();
////		}
//
//		SolutionG solution = new SolutionG();
//		solution.solution(map);
//		sc.close();
//	}
//}
//
//class SolutionG_Node {
//
//	void solution(int[][] map) {
//		ArrayList<Node> paper = new ArrayList<Node>();
//		ArrayList<Node> roots = new ArrayList<Node>();
//
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				paper.add(new Node(map[i][j], i, j));
//			}
//		}
//
//		paper.sort(Comparator.reverseOrder());
//
//		// debugging - paper
////		for (Node node : paper) {
////			System.out.printf("node : %d, %d, %d\n", node.value, node.x, node.y);
////		}
//
//		for (Node newNode : paper) {
//
//			// 1. roots의 node들 내에서 현재 node와 근처에 있는 node들 가져오기
//			// 2. 근처에 있는 node들에게 현재 node를 자식으로 추가하기
//			this.searchParentNodeAndAddToChild(roots, newNode);
//
//			// 3. root에 연결된 node 개수가 4인지 확인
//			// 4. 4개가 있으면 그 중에서 가장 큰 값이 정답 -> 반환
//
//		}
//
//
//		// debugging - roots
//		for (Node root : roots) {
//			System.out.printf("root : x - %d, y - %d, v - %d\n", root.getX(), root.getY(), root.getValue());
//			for (Node node : root.getChildNodes()) {
//				System.out.printf("\tchild : x - %d, y - %d, v - %d\t\n", node.getX(), node.getY(), node.getValue());
//			}
//		}
//	}
//
//	private void searchParentNodeAndAddToChild(ArrayList<Node> roots, Node newNode) {
//		// 1-1. roots에서 하나씩 꺼내서
//		if (roots.size() == 0) {
//			// 1-2. 없으면 root로 만들어줌
//			roots.add(newNode);
//		} else {
//			// 1-2. 있으면 child를 전부 하나하나 타고 들어가야함
//			boolean exitNearNode = false;
//			for (Node root : roots) {
//				// newNode와 근처에 있는 node가 있을 경우 add
//				if (root.isNearby(newNode)) {
//					root.addChildNode(newNode);
//					newNode.setParentNode(root);
//					exitNearNode = true;
//				}
//				for (Node node : root.getChildNodes()) {
//					if (node.isNearby(newNode)) {
//						node.addChildNode(newNode);
//						newNode.setParentNode(node);
//						exitNearNode = true;
//					}
//				}
//			}
//			
//			if(!exitNearNode)
//				roots.add(newNode);
//		}
//	}
//
//	class MyTree {
//		// one Parent Many Children Tree
//		private Node root;
//
//		public MyTree() {
//			super();
//		}
//
//		public MyTree(Node root) {
//			super();
//			this.root = root;
//		}
//
//		public Node getRoot() {
//			return root;
//		}
//
//		public void setRoot(Node root) {
//			this.root = root;
//		}
//
//		void add(Node newNode) {
////			if (root == null) {
////				root = newNode;
////			} else {
////				children.addChildNode(newNode);
////				newNode.addParentNode(children);
////				children = newNode;
////			}
//		}
//
//	}
//
//	class Node implements Comparable<Node> {
//		private int value;
//		private int x;
//		private int y;
//
//		private Node parent;
//		private ArrayList<Node> children;
//
//		Node(int value, int x, int y) {
//			this.value = value;
//			this.x = x;
//			this.y = y;
//			this.parent = null;
//			this.children = new ArrayList<Node>();
//		}
//
//		public int getValue() {
//			return value;
//		}
//
//		public void setValue(int value) {
//			this.value = value;
//		}
//
//		public int getX() {
//			return x;
//		}
//
//		public void setX(int x) {
//			this.x = x;
//		}
//
//		public int getY() {
//			return y;
//		}
//
//		public void setY(int y) {
//			this.y = y;
//		}
//
//		Node getParentNodes() {
//			return this.parent;
//		}
//
//		void setParentNode(Node parentNode) {
//			this.parent = parentNode;
//		}
//
//		ArrayList<Node> getChildNodes() {
//			return this.children;
//		}
//		
//		void setChildNodes(ArrayList<Node> children) {
//			this.children = children;
//		}
//
//		void addChildNode(Node childNode) {
//			this.children.add(childNode);
//		}
//
//		@Override
//		public int compareTo(Node o) {
//			return this.value - o.value;
//		}
//
//		public boolean isNearby(Node o /* childNode */) {
//			if (this.x == o.x) {
//				if (this.y - 1 == o.y || this.y + 1 == o.y)
//					return true;
//			} else if (this.y == o.y) {
//				if (this.x - 1 == o.x || this.x + 1 == o.x)
//					return true;
//			}
//			return false;
//		}
//	}
//}
