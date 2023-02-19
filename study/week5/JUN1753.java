import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end, cost;
	
	public Node(int next, int cost) {
		this.end = next; // 다음 목적지
		this.cost = cost; // 가중치
	}
	
	@Override
	public int compareTo(Node o) { 
		return this.cost - o.cost; //가중치가 낮은 순으로
	} 
}

public class JUN1753 {
	
	static int V, E, K; // 정점 개수, 간선 개수, 시작 정점
	static int INF = 100_000_000;
	static List<Node>[] route; // 정점 별 정보 입력할 리스트
	static int[] result; // 해당 정점에 가는데 걸린 총 가중치 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점

		route = new ArrayList[V+1]; // 1 ~ V 로 하기 위해 +1 해서 선언 (-1 하면 귀찮은 거 ㅇㅈ?)
		result = new int[V+1];
		Arrays.fill(result, Integer.MAX_VALUE); // 나중에 비교하기 위해 최댓값으로 초기황
		result[K] = 0;// 자신이(시작지점에서) 자신에게 가는 건 0
		
		for(int i = 1; i < route.length; i++) { // 정점 입력 준비
			route[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) { //정점 별 정보 입력
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 시작지
			int v = Integer.parseInt(st.nextToken()); // 도착지
			int w = Integer.parseInt(st.nextToken()); // 가중치
			route[u].add(new Node(v, w)); // 정보 입력
		}
		
		sum(K);
		
		for(int i = 1; i < result.length; i++) { // 결과 출력
			System.out.println((result[i]==Integer.MAX_VALUE)?"INF":result[i]);
		}
	}
		
	public static void sum(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0)); // 시작점은 0
		
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 지금 정점의 정보
			for(Node next : route[now.end]) { // 지금 정점과 연결된 정점 가보기
				if(result[next.end] > now.cost + next.cost) { // 기존 결과 값보다 현재 결과 값이 낮으면 
					result[next.end] = now.cost + next.cost;
					pq.add(new Node(next.end, result[next.end]));
				}
			}
		}
	}
}