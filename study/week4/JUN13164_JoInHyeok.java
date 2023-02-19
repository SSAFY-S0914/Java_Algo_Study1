package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN13164_JoInHyeok {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] minArr = new int[N - 1];
        for (int i = 1; i < N; i++) {
            minArr[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(minArr);
        for (int i = 0; i < N - K; i++) {
            result += minArr[i];
        }

        System.out.println(result);
    }
}
