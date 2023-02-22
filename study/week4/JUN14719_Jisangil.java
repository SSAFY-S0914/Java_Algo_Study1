package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN14719_Jisangil {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] blocks = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        int[][] pos = new int[h + 1][2];
        int[] blockCount = new int[h + 1];

        for (int i = 1; i <= w; i++) {
            blockCount[blocks[i]]++;
            for (int j = blocks[i]; j > 0; j--) {
                if (pos[j][0] == 0) {
                    pos[j][0] = i;
                } else {
                    pos[j][1] = i;
                }

            }

        }

        for (int i = h - 1; i > 0; i--) {
            blockCount[i] += blockCount[i + 1];

        }
        int sum = 0;

        for (int i = 1; i < h + 1; i++) {
            if (blockCount[i] == 0 || blockCount[i] == 1) {
                continue;
            }
            sum += Math.max(0, pos[i][1] - pos[i][0]) + 1 - blockCount[i];

        }
        System.out.println(sum);
    }
}
