package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN15486_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2]; // 누적할 배열 사실 1차원으로 만들어도됨
        int[][] arr = new int[n + 1][2]; // 입력받은 값을 넣을 배열
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {

                dp[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dp[i][j];
                if (arr[i][0] + i > n + 1) { // 상담할 날이 퇴사할 날을 넘어가면
                    dp[i][1] = 0; // dp값은 0

                }
            }
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) { //첫날부터 끝까지
            int tmp = dp[i][0]; // 현재 날짜 상담의 소요 날
            int tmp1 = dp[Math.min(i + tmp, n)][0]; // tmp의 소요날이 끝나는 날짜의 소요 날 n이 넘어갈경우엔 n으로
            for (int j = i + tmp; j <= i + tmp + tmp1; j++) { // 현재날의 상담이 끝나는 날부터 상담끝나는날의 소요날이 끝나는 날까지 
                if (j > n) { //범위 넘어가면 break
                    break;
                }
                if (dp[j][0] + j <= n + 1) { // 그날의 상담이 범위를 넘지 않는다면
                    dp[j][1] = Math.max(dp[j][1], arr[j][1] + dp[i][1]); //현재 날과 가능한 그 다음 날들의 맥스 값
                }

            }
            max = Math.max(max, dp[i][1]);
        }
        System.out.println(max);
    }
}
