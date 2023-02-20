import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN20055_YooSeungAh {
	
	static int N;
	static int K;
	static int[] arr;
	static boolean[] robot;
	static int result;
	
	private static void conveyor() {
		
		while(true) {
			result++; // 현재 result단계
			
			// 1번 과정
			// 벨트 회전
			int tmp1 = arr[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = tmp1;
			// 로봇 회전
			if(robot[N - 2]) { // 내리는 위치 전 칸에 로봇이 있었다면
				robot[N - 2] = false; // 로봇을 내려줌
			}
			for (int i = N - 2; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			
			// 2번 과정
			for (int i = N - 2; i >= 0; i--) {
				if(robot[i]) {
					// 마지막 칸에 있는 로봇은 내려간다.
					if(i == N - 2 && arr[N - 1] >= 1) {
						robot[i] = false;
						arr[N - 1]--;
						continue;
					}
					// 앞 칸에 로봇이 없고, 칸의 내구도가 1 이상 남아있다면
					if(!robot[i + 1] && arr[i + 1] >= 1) {
						// 로봇이 한 칸 이동하고, 해당 칸의 내구도 -1
						robot[i] = false;
						robot[i + 1] = true;
						arr[i + 1]--;
					}
				}
			}
			
			// 3번 과정
			if(arr[0] >= 1) { // 올리는 칸의 내구도가 0이 아니면
				robot[0] = true; // 로봇을 올려주고
				arr[0]--; // 올리는 칸의 내구도 - 1
			}
			
			// 4번 과정
			int count = 0;
			for (int i = 0; i < N * 2; i++) {
				if(arr[i] == 0) count++;
				if(count >= K) return;
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 컨베이어 벨트 입력
		arr = new int[N * 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 로봇이 있는 배열
		robot = new boolean[N];
		
		// 과정 수행
		conveyor();
		
		// 출력
		System.out.println(result);
	}

}