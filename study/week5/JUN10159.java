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
	int end, re;
	
	public Node(int next, int re) {
		this.end = next; // 비교하는 값
		this.re = re; // 승부 결과 0 : 패, 1 : 승
	}
	
	@Override
	public int compareTo(Node o) { 
		return this.end - o.end; //비교하는 값이 낮은 순으로
	} 
}

public class JUN10159 {
	
	static int N, M; // 정점 개수, 간선 개수, 시작 정점
	static List<Node>[] list; // 정점 별 정보 입력할 리스트
	static int[] result; // 결과를  알 수 있는 수 저장
	static boolean[] nums; // 1~N 선택 했는지 확인 용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder an = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 정점 개수
		M = Integer.parseInt(br.readLine()); // 간선 개수

		list = new ArrayList[N+1]; // 1 ~ N 로 하기 위해 +1 해서 선언 (-1 하면 귀찮은 거 ㅇㅈ?)
		result = new int[N+1];
		nums= new boolean[N+1];
		
		for(int i = 1; i < list.length; i++) { // 정점 입력 준비
			list[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) { //정점 별 정보 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 비교
			int b = Integer.parseInt(st.nextToken()); // 비교
			list[a].add(new Node(b, 1)); // 정보 입력 : 비교 대상, 승
			list[b].add(new Node(a, 0)); // 정보 입력 : 비교 대상, 패
		}
		
		for(int i = 1; i < list.length; i++) {			
			if(list[i].isEmpty()) continue;
			win(i);
			lose(i);
		}
		//System.out.println(Arrays.toString(result));
		for(int i =1; i < result.length; i++) {
			an.append((N-1)-result[i]).append("\n");
		}
		System.out.print(an);
	}
		
	public static void win(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(nums, false);
		pq.add(new Node(s, list[s].get(0).re)); 
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 지금 정점의 정보
			//System.out.println(">>>>>>>>>>>>>> now >>>>>>>>>>>>>>>>");
			//System.out.println(now.end+" "+now.re);
			//System.out.println(">>>>>>>>>>>>>>> next >>>>>>>>>>>>>>");
			for(Node next : list[now.end]) { // 지금 정점과 연결된 정점 가보기
				//System.out.println(next.end+" "+next.re);
				if(next.re == 1 && !nums[next.end]) {
					nums[next.end] = true;
					cnt++;
					pq.add(new Node(next.end, 1));
				}
			}
		}
//		System.out.print(s+" ");
//		System.out.println(cnt);
		result[s] = cnt;
	}
	public static void lose(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(nums, false);
		pq.add(new Node(s, list[s].get(0).re)); 
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 지금 정점의 정보
//			System.out.println(">>>>>>>>>>>>>> now >>>>>>>>>>>>>>>>");
//			System.out.println(now.end+" "+now.re);
//			System.out.println(">>>>>>>>>>>>>>> next >>>>>>>>>>>>>>");
			for(Node next : list[now.end]) { // 지금 정점과 연결된 정점 가보기
				//System.out.println(next.end+" "+next.re);
				if(next.re == 0 && !nums[next.end]) {
					nums[next.end] = true;
					cnt++;
					pq.add(new Node(next.end, 1));
				}
			}
		}
//		System.out.println(s+" ");
//		System.out.println(cnt);
		result[s] += cnt;
	}
}