package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN11404_Jisangil {
    private static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수
        int[][] costs = new int[n + 1][n + 1];  // 모든 도시의 이동할 수 있는 배열
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    costs[i][j] = 0;  // 자기 자신일때는 0
                } else {
                    costs[i][j] = INF; // 무한으로 초기화 10만 x 100
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            costs[a][b] = Math.min(costs[a][b], cost);  // 이동할 수 있는 곳에 버스의 정보가 여러 개 일 수 있기에 최소값으로 입력 넣어줌
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]); // 플루이드 와샬 알고리즘
                    // 만약 j에서 k를 이동하려고 했을 때 j에서 i를 거쳐 k로 가는게 더 가깝다면 j->k 는 거쳐가는 값으로 수정하는 것
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (costs[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(costs[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
