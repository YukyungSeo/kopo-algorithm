package kr.ac.kopo.week01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G_PhoneListMain_TrieTree {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		System.out.println("testcase : " + testcase);

		for (int i = 0; i < testcase; i++) {
			int cnt = Integer.parseInt(br.readLine());
			System.out.println("ctn : " + cnt);
			
			String[] phoneList = new String[cnt];
			for (int j = 0; j < cnt; j++) {
				phoneList[j] = br.readLine();

				// debugging - phoneList
//				System.out.println("phoneList[" + j + "] : " + phoneList[j]);
			}

			Solution solution = new Solution();
			solution.solution(phoneList);
		}

		br.close();
	}
}

class Solution {
	public void solution(String[] phoneList) {

		TrieTree trieTree = new TrieTree();

		for (int book = 0; book < phoneList.length; book++) {
			trieTree.insert(phoneList[book]);
		}
		System.out.println(trieTree.getSize());

//		for (int idx = 1; idx < phones.size(); idx++) {
//			String p1 = phones.get(idx - 1);
//			String p2 = phones.get(idx);
//
//			int size1 = phones.get(idx - 1).length();
//			if (size1 <= p2.length() && p1.equals(p2.substring(0, size1))) {
////					System.out.println(p1 + ", " + p2);
//				check[book] = false;
//				break;
//			}
//		}
//
//		for (boolean b : check) {
//			System.out.println(b ? "YES" : "NO");
//		}
	}
}

class TrieNode {
	private Map<Character, TrieNode> childNodes = new HashMap<Character, TrieNode>();
	private boolean isLastChar;

	TrieNode() {

	}

	/* getter & setter */
	public Map<Character, TrieNode> getChildNodes() {
		return childNodes;
	}

	public boolean isLastChar() {
		return isLastChar;
	}

	public void setLastChar(boolean isLastStr) {
		this.isLastChar = isLastStr;
	}

}

class TrieTree {
	private TrieNode root;
	private int size;

	TrieTree() {
		this.root = new TrieNode();
	}

	/* getter & setter */
	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/* method */
	public void insert(String word) {
		TrieNode thisNode = this.root;

		for (int i = 0; i < word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), chr -> new TrieNode());
		}

		thisNode.setLastChar(true);
		this.size++;
	}

	public boolean contains(String word) {
		TrieNode thisNode = this.root;

		for (int i = 0; i < word.length(); i++) {
			char chr = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(chr);

			if (node == null)
				return false;

			thisNode = node;
		}

		return thisNode.isLastChar();
	}

	public void delete(String word) {
		if (delete(this.root, word, 0))
			this.size--;
	}

	public boolean delete(TrieNode thisNode, String word, int index) {
		char character = word.charAt(index);

		// 아예 없는 단어인 경우 에러 출력
		if (!thisNode.getChildNodes().containsKey(character))
			throw new Error("There is no [" + word + "] in this Trie.");

		TrieNode childNode = thisNode.getChildNodes().get(character);
		index++;

		if (index == word.length()) {

			// 노드는 존재하지만 insert한 단어가 아닌 경우 에러 출력
			if (!childNode.isLastChar())
				throw new Error("There is no [" + word + "] in this Trie.");

			childNode.setLastChar(false);

			// 삭제 대상 언어의 제일 끝으로써 자식 노드가 없으면(이 단어를 포함하는 더 긴 단어가 없으면) 삭제 시작
			if (childNode.getChildNodes().isEmpty())
				thisNode.getChildNodes().remove(character);

		} else {

			// 콜백 함수
			delete(childNode, word, index);

			// 삭제 중, 자식 노드가 없고 현재 노드로 끝나는 다른 단어가 없는 경우 이 노드 삭제
			if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
				thisNode.getChildNodes().remove(character);

		}
		return true;
	}

}