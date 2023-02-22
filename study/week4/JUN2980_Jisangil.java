package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN2980_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] light = new int[n + 1][3];
        int start = 0;
        int time = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                light[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            start += light[i][0] - light[i - 1][0];
            time += light[i][0] - light[i - 1][0];

            int tmp = time % (light[i][1] + light[i][2]);
            if (tmp <= light[i][1]) {
                time += (light[i][1] - tmp);
            }
        }
        time += (l - start);
        System.out.println(time);
    }


}