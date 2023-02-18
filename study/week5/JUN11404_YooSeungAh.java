import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN11404_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int MAX_VALUE = (int)10e8;
		
		// 도시의 개수 n 입력
		int n = Integer.parseInt(br.readLine());
		// 버스의 개수 m 입력
		int m = Integer.parseInt(br.readLine());
		// 비용 최소값을 담을 배열 초기화
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], MAX_VALUE);
			// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
			graph[i][i] = 0;
		}
		// m개의 버스 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있으므로 비교해서 더 작은 값 넣어줌
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		// 플로이드 워셜
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		// 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(graph[i][j] == MAX_VALUE) sb.append("0 ");
				else sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}