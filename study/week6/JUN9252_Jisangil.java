package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUN9252_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");
        int[] dp;
        String[] sdp;
        if (a.length < b.length) {
            dp = new int[b.length];
            sdp = new String[b.length];
            for (int i = 0; i < a.length; i++) {
                int tmp = 0;
                String stmp = "";
                for (int j = 0; j < b.length; j++) {
                    if (tmp < dp[j]) {
                        tmp = dp[j];
                        stmp = sdp[j];
                        if (a[i].equals(b[j])){
                            continue;
                        }
                    }

                    if (a[i].equals(b[j])) {
                        dp[j] = tmp + 1;
                        sdp[j] = stmp + b[j];
                    }

                }
            }
        } else {
            dp = new int[a.length];
            sdp = new String[a.length];
            for (int i = 0; i < b.length; i++) {
                int tmp = 0;
                String stmp = "";
                for (int j = 0; j < a.length; j++) {
                    if (tmp < dp[j]) {
                        tmp = dp[j];
                        stmp = sdp[j];
                        if (b[i].equals(a[j])){
                            continue;
                        }
                    }

                    if (b[i].equals(a[j])) {
                        dp[j] = tmp + 1;
                        sdp[j] = stmp + a[j];
                    }
                }
            }
        }
        int idx = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                idx = i;
                max = dp[i];
            }
        }


        System.out.println(dp[idx]);
        if (dp[idx] != 0) {
            System.out.println(sdp[idx]);
        }
    }
}
