import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN13164_YooSeungAh {

	// K개의 그룹으로 만들 수 있다는 뜻은
	// 가장 키 차이가 많이 나는 원생 (K - 1)명을 다른 그룹으로 찢어 놓을 수 있다는 뜻.
	// 앞 사람과의 키 차이를 정렬해 가장 많이 차이나는 (K - 1)를 뺀
	// 나머지 차이들을 모두 더하면 답이다.
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 차례로 들어오는 N개의 키의 차를 저장할 배열
		st = new StringTokenizer(br.readLine());
		int[] sub = new int[N];
		int tmp1 = Integer.parseInt(st.nextToken());
		for (int i = 1; i < sub.length; i++) {
			int tmp2 = Integer.parseInt(st.nextToken());
			sub[i] = tmp2 - tmp1;
			tmp1 = tmp2;
		}
		
		// 키 차이를 저장한 배열 정렬
		Arrays.sort(sub);
		
		// K - 1개 뺀 나머지 다 더하기
		int result = 0;
		for (int i = 0; i < N - K + 1; i++) {
			result += sub[i];
		}
		
		// 답 출력
		System.out.println(result);
	}

}
