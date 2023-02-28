import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN2616_YooSeungAh {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 객차 수
		int[][] arr = new int[5][n]; // 객차 별 손님의 수와 dp 계산을 넣을 배열
		st = new StringTokenizer(br.readLine()); // 객차 별 손님 수 입력
		for (int i = 0; i < n; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
		int l = Integer.parseInt(br.readLine()); // 최대로 끌 수 있는 객차 수
		
		int sum = 0;
		for (int i = 0; i < n - l + 1; i++) {
			if(i == 0) for (int j = 0; j < l; j++) sum += arr[0][j]; // 처음만 i부터 l개 합을 구하고
			else sum = sum - arr[0][i - 1] + arr[0][i + l - 1]; // 다음부턴 앞에 더해주고 맨 뒤 빼줌
			arr[1][i] = sum; // i~i+l-1까지의 합을 arr[1][i]에 담는다.

			// 첫 번째 기관차는 i번째 객차까지 검사했을 때 선택할 수 있는 가장 많은 손님 수 저장
			if(i == 0) arr[2][i] = arr[1][i];
			else arr[2][i] = Math.max(arr[2][i - 1], arr[1][i]);
			
			// 두 번째 기관차는 첫 번째 기관차가 선택할 수 있는 최대 손님 수 + 자신이 선택할 수 있는 최대 손님 수
			if(i >= l) { // 이미 첫 번째 기관차가 선택한 이후이므로 인덱스가 l부터 시작해야 한다.
				arr[3][i] = Math.max(arr[3][i - 1], arr[2][i - l] + arr[1][i]);
			}
			
			// 세 번째 기관차는 두 번째 기관차까지 선택할 수 있는 최대 손님 수 + 자신이 선택할 수 있는 최대 손님 수
			if(i >= 2 * l) { // 이미 두 번째 기관차까지 선택한 이후이므로 인덱스가 2l부터 시작해야 한다.
				arr[4][i] = Math.max(arr[4][i - 1], arr[3][i - l] + arr[1][i]);
			}
		}
		
		// 세 번째 기관차의 마지막 경우의 수가 담긴 곳이 최대값
		System.out.println(arr[4][n - l]);
	}

}