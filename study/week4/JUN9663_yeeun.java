import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] row; // row[i] = j
    // i번째 row에 j번째 col에 위치
    static int cnt = 0;

   static boolean isPromising(int x) {
        for (int i = 0; i < x; ++i) {
            if ((row[i] == row[x]) || Math.abs(row[x] - row[i]) == Math.abs(x - i)) {
                return false;
            }
        }
        return true;
    }
    static void sol(int i) {
        if (i >= n) {
            cnt++;
            return;
        }
        for (int j = 0; j < n; j++) {
            row[i] = j;
            if (!isPromising(i)) continue;
            sol(i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        row = new int[n];
        sol(0);
        System.out.println(cnt);
    }
}
