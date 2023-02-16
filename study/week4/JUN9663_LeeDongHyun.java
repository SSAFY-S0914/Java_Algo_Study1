import java.util.Scanner;

public class JUN9663_LeeDongHyun {
    static int n;
    static int result;
    static int[] board;

    /**
     * 한 행에 하나만 선택할 수 있음 -> 1차원 배열로 해결 가능
     * 한 열에 하나만 선택할 수 있음 -> 배열에서 같은 값이 있으면 안됨
     * 같은 대각선 상에 있으면 안됨 -> 행 - 행 == abs(열 - 열) -> 같은 대각선에 위치함
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        int count = 0;
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int cnt) {
        if (cnt == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[cnt] = i;
            if (isValid(cnt)) {
                dfs(cnt + 1);
            }
        }
    }

    static boolean isValid(int idx) {
        for (int i = 0; i < idx; i++) {
            if (board[idx] == board[i]) { // 열 중복 (세로)
                return false;
            }
            if (idx - i == Math.abs(board[idx] - board[i])) { // 대각선 중복
                return false;
            }
        }
        return true;
    }
}
