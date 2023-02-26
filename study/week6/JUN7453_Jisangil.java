package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN7453_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        int idx = 0;
        for (Integer tmp : arr[0]) {
            for (Integer tmp1 : arr[1]) {
                ab[idx++] = tmp + tmp1;
            }
        }

        idx = 0;
        for (Integer tmp : arr[2]) {
            for (Integer tmp1 : arr[3]) {
                cd[idx++] = tmp + tmp1;
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);
        long count = 0;
        int start = 0;
        int last = cd.length - 1;
        while (start < n * n && last >= 0) {
            int a = ab[start];
            int b = cd[last];
            if (a + b > 0) {
                last--;
            } else if (a + b < 0) {
                start++;
            } else {
                int aCount = 0;
                for (int i = start; i < ab.length; i++) {
                    if (a == ab[i]) {
                        aCount++;
                    } else {
                        break;
                    }
                }
                int bCount = 0;
                for (int i = last; i >= 0; i--) {
                    if (b == cd[i]) {
                        bCount++;
                    } else {
                        break;
                    }
                }
                count += (long) aCount * bCount;
                start += aCount;
                last -= bCount;
            }
        }

        System.out.println(count);
    }
}