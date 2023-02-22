package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JUN1753_Jisangil {
    static class Node {
        int last; // 다음 노드의 번호
        int cost; // 해당 노드의 비용

        public Node(int last, int cost) {
            this.last = last;
            this.cost = cost;
        }
    }

    static int K;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.get(u).add(new Node(v, w));
        }

        bfs();

    }

    public static void bfs() {
        int[] dist = new int[nodes.size()]; // 갈 수 있는 비용
        Arrays.fill(dist, Integer.MAX_VALUE); // 무한으로 초기화
        boolean[] visit = new boolean[nodes.size()]; // 방문했는지 확인
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        // 비용으로 우선순위를 둠
        q.add(new Node(K, 0)); // 비용 0 으로 시작
        dist[K] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll().last;

            if (visit[tmp]) { // 방문했다면 패스
                continue;
            }
            visit[tmp] = true;
            for (int i = 0; i < nodes.get(tmp).size(); i++) {
                Node currentNode = nodes.get(tmp).get(i);

                if (dist[currentNode.last] > currentNode.cost + dist[tmp]) { // 만약 다음 노드가는 비용이
                    // 현재 위치의 비용에서 이동 간선의 비용의 합보다 크다면 값 바꿔줌
                    dist[currentNode.last] = currentNode.cost + dist[tmp];
                    q.add(new Node(currentNode.last, dist[currentNode.last]));
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodes.size(); i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}

