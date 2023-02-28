package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUN9252_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(""); //첫번째 스트링
        String[] b = br.readLine().split(""); // 두번째 스트링
        int[] dp; // 누적할 디피 값
        String[] sdp; //누적할 문자열
        if (a.length < b.length) { // 만약 두번째 문자열이 길면
            dp = new int[b.length]; //긴 곳으로  dp 생성
            sdp = new String[b.length];
            for (int i = 0; i < a.length; i++) { //첫번째 문자열의 첫번째 문자부터 시작
                int tmp = 0; // 시작은 0으로 초기화
                String stmp = ""; // 문자열도 공백
                for (int j = 0; j < b.length; j++) { // 두번째 문자열을 전체 돔
                    if (tmp < dp[j]) { //만약 dp값이 더크면 
                        tmp = dp[j]; // tmp를 올려줌
                        stmp = sdp[j]; // 문자열도 추가
                        if (a[i].equals(b[j])){ // 만약 dp값을 설정해주었는데 같은 문자열이면 맥스값으로만 설정하고 넘어감
                            continue;
                        }
                    }

                    if (a[i].equals(b[j])) { // 만약 같은 문자열이면
                        dp[j] = tmp + 1; // 현재 최고 값인 tmp를 현재 문자열 위치에 tmp+1
                        sdp[j] = stmp + b[j]; //문자열도 현재 문자열 추가
                    }

                }
            }
        } else { // 반대의 경우 똑같은 코드
            dp = new int[a.length];
            sdp = new String[a.length];
            for (int i = 0; i < b.length; i++) {
                int tmp = 0;
                String stmp = "";
                for (int j = 0; j < a.length; j++) {
                    if (tmp < dp[j]) {
                        tmp = dp[j];
                        stmp = sdp[j];
                        if (b[i].equals(a[j])){
                            continue;
                        }
                    }

                    if (b[i].equals(a[j])) {
                        dp[j] = tmp + 1;
                        sdp[j] = stmp + a[j];
                    }
                }
            }
        }
        int idx = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                idx = i;
                max = dp[i];
            }
        }

        //max의 인덱스를 찾아 
        System.out.println(dp[idx]);
        if (dp[idx] != 0) {
            System.out.println(sdp[idx]);
        }
    }
}
