import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

class Node {
	int no; // 물건의 번호
	ArrayList<Integer> left; // no보다 더 가벼운 노드 리스트
	ArrayList<Integer> right; // no보다 더 무거운 노드 리스트
	
	Node(int no) {
		this.no = no;
		this.left = new ArrayList<>();
		this.right = new ArrayList<>();
	}
}

public class JUN10159_YooSeungAh {
	
	static ArrayList<Node> list;
	static ArrayList<Set<Integer>> leftNodeList; // node보다 작은 노드를 구할 때 사용할  set
	static ArrayList<Set<Integer>> rightNodeList; // node보다 큰 노드를 구할 때 사용할 set
	
	private static void countLeftNode(Node n) {
		if(n.left.isEmpty()) {
			return;
		}
		
		Set<Integer> leftNode = leftNodeList.get(n.no);
		for (int i = 0; i < n.left.size(); i++) {
			int ll = n.left.get(i);
			leftNode.add(ll);
			
			if(leftNodeList.get(ll).isEmpty()) { // 확인하려는 노드의 왼쪽 리스트가 비었다면 재귀로 확인
				countLeftNode(list.get(ll));
			}
			leftNode.addAll(leftNodeList.get(ll));
		}
	}
	
	private static void countRightNode(Node n) {
		if(n.right.isEmpty()) {
			return;
		}
		
		Set<Integer> rightNode = rightNodeList.get(n.no);
		for (int i = 0; i < n.right.size(); i++) {
			int rr = n.right.get(i);
			rightNode.add(rr);
			
			if(rightNodeList.get(rr).isEmpty()) { // 확인하려는 노드의 왼쪽 리스트가 비었다면 재귀로 확인
				countRightNode(list.get(rr));
			}
			rightNode.addAll(rightNodeList.get(rr));
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// N, M 입력
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// N개의 노드 리스트
		list = new ArrayList<>();
		// 인덱스에 해당하는 노드보다 작은 노드를 담을 set list
		leftNodeList = new ArrayList<>();
		// 인덱스에 해당하는 노드보다 큰 노드를 담을 set list
		rightNodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new Node(i));
			leftNodeList.add(new HashSet<>());
			rightNodeList.add(new HashSet<>());
		}
		
		// M개의 비교 결과 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list.get(l).right.add(r);
			list.get(r).left.add(l);
		}

		
		for (int i = 1; i <= N; i++) {
			countLeftNode(list.get(i));
			countRightNode(list.get(i));
			sb.append((N - 1 - leftNodeList.get(i).size() - rightNodeList.get(i).size()) + "\n");
		}
		
		System.out.println(sb);
	}
}
