package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JUN2002_Jisangil {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>(); //차와 현재 위치를 저장할 맵
        for (int i = 1; i <= n; i++) {
            map.put(br.readLine(), i);
        }
        int[] add = new int[n + 1]; // 만약 4번이 1번위치로 올경우 1번은 2번이여야 하므로 더할 배열
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();  
            int tmpValue = map.get(tmp);  // 추월하기 전에 위치의 값
            if (tmpValue+add[map.get(tmp)] > i){  // 추월하기 전의 값과 몇대가 추월해서 누적된 값의 합보다 현재 위치가 작으면
                count++; // 카운트 증가
                for (int j = 1; j < tmpValue; j++) {
                    add[j]++; // 4번이 1번으로 올경우 1번부터 3번까지는 +1씩 누적해준다고 보면됨
                }
            }
        }

        System.out.println(count);

    }
}
