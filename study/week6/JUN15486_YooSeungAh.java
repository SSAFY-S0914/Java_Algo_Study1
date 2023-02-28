import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN15486_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		
		int[] profit = new int[N + 2]; // 인덱스일 별 최대 수익
		int maxProfit = 0; // 현재 일수에서 벌어 놓은 있는 최대 이익
		int result = 0; // 가장 큰 이익
		
		for (int i = 1; i < N + 1; i++) { // 1일부터 N일까지
			// i일에 시작할 수 있는 일 정보를 입력 받고
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			
			maxProfit = Math.max(maxProfit, profit[i - 1]); // 전날까지 벌어놓은 최대 이익을 구한다
			
			// i일에 일을 시작해서 i + day - 1에 일이 끝났을 때의 최대 이익을 profit에 저장한다
			if(i + day - 1 <= N) {
				profit[i + day - 1] = Math.max(profit[i + day - 1], maxProfit + pay);
				result = Math.max(result, profit[i + day - 1]);
			}
		
		}
		
		System.out.println(result);
	}

}