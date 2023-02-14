import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN14719_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 세로 길이 H, 가로 길이 W
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 블럭의 높이 입력
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 빗물이 고이는 구간 찾기
		int result = 0;
		int start = 0, end = 0;
		for (start = 0; start < W - 1;) {
			if (arr[start] == 0) { // 0이 아닌 곳까지 이동
				start++;
				continue;
			}
			
			int max_length = arr[start]; // 왼쪽 벽의 크기가 물을 고이게 만들 수 있는 최대 높이
w1:			while(max_length >= 1) { // 최대 높이를 한 칸 씩 내려가며 오른쪽 벽의 최대 높이를 구한다
				for (end = start + 1; end < W; end++) { // 오른쪽 확인
					if(arr[end] >= max_length) { // 오른쪽 중 가장 가까운 max_length 길이의 벽을 찾았다면
						int max = arr[start] < arr[end] ? arr[start] : arr[end]; // 왼쪽 벽과 오른쪽 벽 중 더 작은 벽을 기준으로
						for (int i = start + 1; i < end; i++) { // 고인 물의 크기를 더해준다.
							result += max - arr[i];
						}
						break w1; // 최대 높이를 구해 고인물의 크기를 모두 구했으므로 while문 탈출
					}
				}
			max_length--; // 가능한 최대 높이를 낮춰가며 오른쪽 중 가장 높은 크기의 벽을 찾는다.
			}
			
			start = end; // 현재 구간의 고인물 크기를 모두 구했으므로, 현재 오른쪽 벽을 왼쪽벽으로 하여 다시 오른쪽 구간을 구한다.
		}
		
		System.out.println(result);
	}

}