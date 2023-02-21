import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static int[] minCost;
    static List<Node>[] nodes;
    static boolean[] visit;
    static int V,E,START;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine());

        minCost = new int[V+1];
        visit = new boolean[V+1];
        nodes = new List[V+1];

        //초기화
        for (int i = 0 ; i<= V ;i++){
            nodes[i] = new ArrayList<>();
        }

        // 노드 입력 받기
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, weight));
        }

        dijkstra();
        for (int i =1 ; i <= V; i++){
            String str = minCost[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(minCost[i]);
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(){
        // cost 로 우선순위 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((v1,v2)-> v1.cost-v2.cost);
        pq.offer(new Node(START,0));
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[START] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            //방문한 노드면 Continue;
            if(visit[cur.dest]){
                continue;
            }
            visit[cur.dest] = true;

            for (Node next : nodes[cur.dest]){

                if(!visit[next.dest] && minCost[next.dest] > cur.cost + next.cost){
                    minCost[next.dest] = cur.cost + next.cost;
                    pq.offer(new Node(next.dest, minCost[next.dest]));
                }
            }
        }
    }
}