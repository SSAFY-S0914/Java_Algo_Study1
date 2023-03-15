import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN15565_YooSeungAh {

	public static void main(String[] args) throws Exception{
		
		final int INF = (int) 10e6;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 인형 정보 입력
		int[] arr = new int[N];
		int s = -1, e = -1; // 연속된 인형 집합의 시작 인덱스 s, 끝 인덱스 e
		int c = 0; // s는 처음 나오는 1의 위치, e는 K번째 나오는 1의 위치를 가리키기 위해 1이 나온 개수를 세는 변수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == 1) c++;
			if(c == 1) s = i;
			if(c == K) e = i;
		}
		
		int result = INF;
		while(s >= 0 && s < N && e >= 0 && e < N) {
			result = Math.min(result, e++ - s++ + 1); // 최소 길이 갱신
			
			while(s < N && arr[s] != 1) s++; // 시작 인덱스에 다음 1이 나올 때까지
			while(e < N && arr[e] != 1) e++; // 끝 인덱스에 다음 1이 나올 때까지
		}
		
		if(result == INF) System.out.println(-1);
		else System.out.println(result);
	}

}