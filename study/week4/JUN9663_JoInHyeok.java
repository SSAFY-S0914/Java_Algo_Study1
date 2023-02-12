package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JUN9663_JoInHyeok {

    static int N;

    static boolean[] visit;
    static int result = 0;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        select = new int[N];

        recur(0);

        System.out.println(result);
    }

    private static void recur(int depth) {
        if (depth == N) {
            //N개를 선택한 경우
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            //x 방향 검사
            if (visit[i]) {
                continue;
            }

            boolean isDuplicate = false;

            // 대각선 검사
            for (int dy = 0; dy < depth; dy++) {
                int selectX = select[dy];
                if (Math.abs((depth) - dy) == Math.abs(selectX - i)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                continue;
            }

            visit[i] = true;
            select[depth] = i;
            recur(depth + 1);
            visit[i] = false;
        }
    }
}
