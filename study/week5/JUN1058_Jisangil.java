package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class JUN1058_Jisangil {
    static int n;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {

            String tmp = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                if (tmp.charAt(j - 1) == 'Y') {
                    arr[i][j] = true;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, bfs(i));
        }
        System.out.println(max);
    }

    private static int bfs(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean visit[] = new boolean[n + 1];
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[1] == 3) {
                break;
            }
            if (visit[tmp[0]]) {
                continue;
            }
            visit[tmp[0]] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[tmp[0]][i]) {
                    q.add(new int[]{i, tmp[1] + 1});
                }

            }
        }
        int count = 0;
        for (int i = 1; i < visit.length; i++) {
            if (i == start) {
                continue;
            }
            if (visit[i]) {
                count++;
            }
        }
        return count;
    }

}