package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN7453_Jisangil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ab = new int[n * n]; // ab를 합한 배열
        int[] cd = new int[n * n]; // cd를 합한 배열
        int idx = 0;
        for (Integer tmp : arr[0]) {
            for (Integer tmp1 : arr[1]) {
                ab[idx++] = tmp + tmp1; // ab가능한 값 만들기
            }
        }

        idx = 0;
        for (Integer tmp : arr[2]) {
            for (Integer tmp1 : arr[3]) {
                cd[idx++] = tmp + tmp1;
            }
        }

        Arrays.sort(ab); // 정렬
        Arrays.sort(cd);
        long count = 0;
        int start = 0; //ab의 시작지점
        int last = cd.length - 1; // cd의 시작지점
        while (start < n * n && last >= 0) {
            int a = ab[start];  // 가장 작은
            int b = cd[last]; // 가장 큰
            if (a + b > 0) { // 합이 0보다 크면
                last--; // 큰 값 낮추기
            } else if (a + b < 0) {
                start++; // 작은 값 낮추기
            } else { // 같으면
                int aCount = 0;
                for (int i = start; i < ab.length; i++) {
                    if (a == ab[i]) {
                        aCount++;
                    } else {
                        break;
                    }
                }
                int bCount = 0;
                for (int i = last; i >= 0; i--) {
                    if (b == cd[i]) {
                        bCount++;
                    } else {
                        break;
                    }
                }
                count += (long) aCount * bCount;  // aCount는 ab 배열에서 같은 값의 개수 bCount도 마찬가지 가능한 개수만큼 더해줌
                start += aCount; //같은거 다음으로 증가
                last -= bCount;
            }
        }

        System.out.println(count); // 
    }
}
