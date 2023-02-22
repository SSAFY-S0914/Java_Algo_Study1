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
        int[][] dp = new int[n + 1][2];
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {

                dp[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dp[i][j];
                if (arr[i][0] + i > n + 1) {
                    dp[i][1] = 0;

                }
            }
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            int tmp = dp[i][0];
            int tmp1 = dp[Math.min(i + tmp, n)][0];
            for (int j = i + tmp; j <= i + tmp + tmp1; j++) {
                if (j > n) {
                    break;
                }
                if (dp[j][0] + j <= n + 1) {
                    dp[j][1] = Math.max(dp[j][1], arr[j][1] + dp[i][1]);
                }

            }
            max = Math.max(max, dp[i][1]);
        }
        System.out.println(max);
    }
}
