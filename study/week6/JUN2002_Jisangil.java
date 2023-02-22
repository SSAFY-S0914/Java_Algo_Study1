package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JUN2002_Jisangil {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(br.readLine(), i);
        }
        int[] add = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            int tmpValue = map.get(tmp);
            if (tmpValue+add[map.get(tmp)] > i){
                count++;
                for (int j = 1; j < tmpValue; j++) {
                    add[j]++;
                }
            }
        }

        System.out.println(count);

    }
}
