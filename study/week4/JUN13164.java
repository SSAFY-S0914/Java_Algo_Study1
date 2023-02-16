package week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class JUN13164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 만들 조 수

		int[] stature = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //학생들 키
		int[] s_sub = new int[N-1];

		for(int i = 0; i < N-1; i++) {
			s_sub[i] = stature[i+1] - stature[i]; // 학생들 키의 차이를 저장
		}

		Arrays.sort(s_sub); // 차이가 적은 순으로 정력

		int ans = 0;
		for(int i = 0; i < N-K; i++) {
			ans+=s_sub[i];
		}

		System.out.println(ans);
		br.close();
	}
}