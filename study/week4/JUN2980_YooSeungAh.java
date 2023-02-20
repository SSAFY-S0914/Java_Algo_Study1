import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN2980_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 신호등의 개수 N, 도로의 길이 L 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 신호등의 정보 입력
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0; // 이동 시간
		int l = 0; // 이동 거리
		int idx = 0; // 신호등 정보 배열 접근 인덱스
		
		// 이동 시간 구하기
		while(l < L) {
			// 신호등을 모두 지나왔을 경우
			if(idx == N) {
				// 남은 거리는 바로 이동
				time += L - l;
				break;
			}
			
			int d = arr[idx][0];
			int r = arr[idx][1];
			int g = arr[idx][2];
			
			// 현재 거리에서 가장 가까운 신호등까지는 멈추지 않고 간다.
			time += d - l;
			l = d;
			
			// 신호등이 현재 빨간불인지, 초록불인지 확인
			if(time % (r + g) < r) { // 빨간불
				time += r - (time % (r + g));
			}
			
			// 다음 신호등으로 이동
			idx++;
		}
		
		// 출력
		System.out.println(time);
	}

}