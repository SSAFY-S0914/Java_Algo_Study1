import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 도시의 개수
    static int M; // 버스의 개수
    static int[][] dist;
    static int MAX_VALE = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];

        //초기화
        for (int i = 0 ; i <= N ; i++){
            for (int j = 0 ; j <= N; j++){
                if(i == j) continue;
                dist[i][j] = MAX_VALE;
            }
        }

        for (int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(cost, dist[a][b]);
        }
        for (int i = 1 ; i <= N ; i++){

            for (int j = 1; j <= N; j++){

                for (int k = 1; k <= N; k++){
                    if(dist[j][i]+dist[i][k] < dist[j][k]){
                        dist[j][k] =dist[j][i]+dist[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N ; i++){
            for (int j = 1; j <= N; j++){
                if(dist[i][j]==MAX_VALE){//방문할 수 없는 경우 --> 0 으로 표사.
                    sb.append("0");
                }else {
                    sb.append(dist[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}