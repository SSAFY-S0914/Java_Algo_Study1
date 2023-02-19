package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JUN18352_Jisangil {
    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static List<Node>[] nodes;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        nodes = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, 1));
        }

        dijk(x);
    }

    private static void dijk(int x) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 987654321);
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[x] = 0;

        q.add(new Node(x, 0));

        while (!q.isEmpty()) {
            int index = q.poll().next;

            if (visit[index]) {
                continue;
            }
            visit[index] = true;

            for (int i = 0; i < nodes[index].size(); i++) {
                Node tmpNode = nodes[index].get(i);
                if (dist[tmpNode.next] > dist[index] + tmpNode.cost) {
                    dist[tmpNode.next] = dist[index] + tmpNode.cost;

                    q.add(new Node(tmpNode.next, dist[tmpNode.next]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}