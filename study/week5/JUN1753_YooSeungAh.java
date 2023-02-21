import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}

	// 거리가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node other) {
		return this.distance - other.getDistance();
	}	
}

public class JUN1753_YooSeungAh {
	
	static ArrayList<ArrayList<int []>> list;
	static int[] distance;
	
	private static void dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0)); // 시작 정점 큐에 삽입
		distance[start] = 0; // 시작 정점의 거리는 0
		
		while(!pq.isEmpty()) { // 큐가 빌 때까지
			Node tmp = pq.poll(); // 가장 거리가 짧은 정점의 정보 꺼내기
			int now = tmp.getIndex(); // 현재 정점
			int dis = tmp.getDistance(); // 현재 정점의 최단 거리
			if(distance[now] < dis) continue; // 현재 정점이 이미 처리된 적 있는 정점이면 무시
			ArrayList<int []> nowList = list.get(now); // 현재 정점에 연결되어 있는 간선 정보 가져오기
			for (int i = 0; i < nowList.size(); i++) {
				int cost = dis + nowList.get(i)[1];
				// 현재 정점을 거쳐서 다음 정점으로 가는 길이가 더 짧다면
				if(cost < distance[nowList.get(i)[0]]) {
					distance[nowList.get(i)[0]] = cost; // 현재 정점을 거쳐서 가게 해주고
					pq.add(new Node(nowList.get(i)[0], cost)); // 큐에 넣어줌
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 정점의 개수 V, 간선의 개수 E 입력
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 시작 정점의 번호 K
		int K = Integer.parseInt(br.readLine());
		
		// E개의 간선 정보 입력
		// 가장 가까운 경로 저장할 배열 최대값으로 초기화
		list = new ArrayList<>();
		distance = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new int[] {v, w});
		}

		// 정점 거리 구해주기
		dijk(K);
		
		// 출력
		for (int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i] + "\n");
		}
		System.out.println(sb);
	}

}