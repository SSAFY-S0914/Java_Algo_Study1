package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN20055_Jisangil {
    static int n;
    static int k;
    static int[] map;
    static boolean[] robot;
    static int left;
    static int right;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[n * 2];

        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        robot = new boolean[n];
        left = 0;
        right = n;

        int result = 0;
        while (k > 0) {
            result++;
            moveBelt();
            moveRobot();
            upRobot();
        }
        System.out.println(result);
    }

    private static void upRobot() {
        if (map[left] >= 1) {
            map[left]--;
            robot[0] = true;
            if (map[left] == 0) {
                k--;
            }
        }
    }

    private static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i]) {
                int next = left + i + 1;
                if (next >= n * 2) {
                    next -= n * 2;
                }
                if (!robot[i + 1] && map[next] >= 1) {
                    map[next] -= 1;
                    robot[i + 1] = true;
                    robot[i] = false;

                    if (map[next] == 0) {
                        k--;
                    }
                }
            }
        }
    }

    private static void moveBelt() {
        left--;
        if (left < 0) {
            left = 2 * n - 1;
        }

        right--;
        if (right < 0) {
            right = 2 * n - 1;
        }

        for (int i = n - 2; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[n - 1] = false;
    }


}
