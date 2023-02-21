import java.io.*;
import java.lang.reflect.Parameter;
import java.util.*;

public class Main {

    static int v,e,k;
    static List<Pair>[] adj;
    static int[] arr;
    static class Pair implements Comparable<Pair> {
        int cost;
        int node;

        public Pair(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        adj = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Pair(w, b));
        }
        int[] dist = dijkstra(k);
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int[] dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, start));
        int[] dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (int i = 0; i < adj[cur.node].size(); i++) {
                int nxtNode = adj[cur.node].get(i).node;
                int nxtCost = cur.cost + adj[cur.node].get(i).cost;
                if (dist[nxtNode] > nxtCost) {
                    dist[nxtNode] = nxtCost;
                    pq.offer(new Pair(nxtCost, nxtNode));
                }
            }
        }
        return dist;
    }
}
