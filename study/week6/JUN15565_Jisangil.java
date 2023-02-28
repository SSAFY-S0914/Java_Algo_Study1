package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JUN15565_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        List<Integer> lion = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 1){ //라이언배열의 라이언 위치만 추가
                lion.add(i);
            }
        }
        if (k>lion.size()){ //라이언이 k개보다 적으면
            System.out.println(-1); // 리턴
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lion.size()-k; i++) { // 라이언의 위치가 0, 4, 6, 9 라고 하고 k가 3이라면 046과 469만 가능하므로
            min = Math.min(min, lion.get(i + k - 1) - lion.get(i) + 1); //k의 크기만큼에서 위치 빼주기
        }

        System.out.println(min);
    }
}
