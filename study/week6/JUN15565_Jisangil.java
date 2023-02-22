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
            if (tmp == 1){
                lion.add(i);
            }
        }
        if (k>lion.size()){
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lion.size()-k; i++) {
            min = Math.min(min, lion.get(i + k - 1) - lion.get(i) + 1);
        }

        System.out.println(min);
    }
}
