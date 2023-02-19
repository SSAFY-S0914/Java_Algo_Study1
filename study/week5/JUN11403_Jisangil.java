package week5;

import java.util.Scanner;

public class JUN11403_Jisangil {
    static int[][] map;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = s.nextInt();
                if (x == 1) {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int i, int j) {

        for (int k = 0; k < map.length; k++) {
            if (map[i][k] == 0 && map[j][k] == 1) {
                map[i][k] = 1;
                dfs(i, k);
            }
        }
    }
}
