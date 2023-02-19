package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN10159_Jisangil {

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 물건 개수
        int m = Integer.parseInt(br.readLine()); // 물건 쌍의 입력 개수

        int[][] nodes = new int[n + 1][n + 1]; // 물건이 비교한 값을 넣어주는 배열

        for (int i = 1; i < n + 1; i++) {  // 초기화
            Arrays.fill(nodes[i], 3000);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a][b] = 1;  // 비교했을 경우 1로 초기화
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (i == j) {  //플루이드 알고리즘이랑 동일
                        nodes[i][j] = 1;
                        continue;
                    }
                    if (nodes[j][k] > nodes[j][i] + nodes[i][k]) { // 그래프와 같은 원리 단일 방향이라면 1로 초기화
                        nodes[j][k] = 1;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (nodes[i][j] == 3000 && nodes[j][i] == 3000) {  // 그래프로 따졌을 때
                    // 내가 상대를 갈 수없고, 상대도 나를 올 수 없다면 count 증가
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


}