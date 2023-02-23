package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN2616_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i] + dp[i - 1];
        }
        int max = Integer.parseInt(br.readLine());


        int[][] dp2 = new int[n + 1][4];

        int result = 0;

        for (int i = 1; i < 4; i++) {
            for (int j = max; j < n + 1; j++) {
                dp2[j][i] = Math.max(dp[j] - dp[j - max] + dp2[j - max][i - 1], dp2[j - 1][i]);
                result = Math.max(result, dp2[j][3]);
            }

        }

//        for (int i = max; i < n + 1; i++) {
//            dp2[i][0] = dp[i];
//            for (int j = i - max; j >= 0; j--) {
////                dp2[i][0] = Math.max(dp2[i][0], dp2[j][0]);
//                if (dp2[j][0] != 0) {
//                    dp2[i][1] = Math.max(dp2[i][1], dp[i] + dp2[j][0]);
//                }
//                if (dp2[j][1] != 0) {
//                    dp2[i][2] = Math.max(dp2[i][2], dp[i] + dp2[j][1]);
//                }
//            }
//            result = Math.max(result, dp2[i][2]);
//        }

//        System.out.println(Arrays.toString(dp));
//        Arrays.stream(dp2).forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println(result);
    }
}
