package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JUN13164_Jisangil {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] shirts = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            q.add(shirts[i] - shirts[i - 1]);
        }

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += q.poll();
        }
        System.out.println(sum);
    }
}
