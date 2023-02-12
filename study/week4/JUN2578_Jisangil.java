import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN2578_Jisangil {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] referee = new int[25];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                referee[i * 5 + j] = tmp;
            }
        }
        for (int i = 0; i < 25; i++) {
            check(bingo, referee[i]);
            if (i >= 11) {
                if (isBingo(bingo)) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }

    }

    private static boolean isBingo(int[][] bingo) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    tmp++;
                } else {
                    break;
                }
            }
            if (tmp == 5) {
                count++;
            }
            tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) {
                    tmp++;
                } else {
                    break;
                }
            }
            if (tmp == 5) {
                count++;
            }
        }
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                tmp++;
            } else {
                break;
            }
        }
        if (tmp == 5) {
            count++;
        }
        tmp = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[4 - i][i] == 0) {
                tmp++;
            } else {
                break;
            }
        }
        if (tmp == 5) {
            count++;
        }
        if (count >= 3) {
            return true;
        }
        return false;
    }

    private static void check(int[][] bingo, int tmp) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == tmp) {
                    bingo[i][j] = 0;
                    break;
                }
            }
        }
    }

}
