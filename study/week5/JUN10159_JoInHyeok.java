import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
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
            dist[a][b] = 1;
        }

        for (int i = 1 ; i <= N ; i++){
            for (int s = 1; s <= N; s++){
                for (int d = 1; d <= N; d++){
                    if(dist[s][i] + dist[i][d] < dist[s][d]){
                        dist[s][d] = dist[s][i]+dist[i][d];
                    }
                }
            }
        }


        for (int i = 1; i <= N ; i++){
            int sum = 0;
            for (int j = 1; j <= N; j++){ // 현재 기준으로 방문하지 않고, 반대도 방문하지 않으면 아에 방문못하는 노드임.
                if(dist[i][j]==MAX_VALE && dist[j][i] == MAX_VALE){
                    sum++;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}