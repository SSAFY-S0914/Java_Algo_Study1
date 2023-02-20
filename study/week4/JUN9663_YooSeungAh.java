import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUN9663_YooSeungAh {
	
	static int N;
	static int[] q;
	static boolean[] hasQueen;
	static int result;
	
	// 1. 체스판의 가로줄, 세로줄에는 각각 하나의 퀸만 놓을 수 있다.
	// 1-1. 위에서부터 퀸을 놓을거라 위는 확인해주지 않아도 됨.
	// 1-2. 따라서 어느 행에 퀸이 있는지는 확인해주지 않아도 되고 어느 열에 퀸이 있는지만 확인하면 됨.
	
	// 2. i번째 행에 퀸을 놓을 차례라면, (0 ~ i-1)행에 놓인 퀸의 대각선에는 퀸을 놓을 수 없음.
	// 2-1. (x, y)에 놓인 퀸의 i행의 대각선 위치는, (i, y - (i - x))와 (i, y + (i - x))이다. (0 <= x <= i - 1)
	private static void queen(int x, int y) {
		q[x] = y;
		hasQueen[y] = true;
		
		// 현재 마지막 행이라면 퀸을 모두 놓는 것에 성공한 경우이므로 result + 1
		if(x == N - 1) {
			result++;
			// 메소드 들어올 때, y열에 퀸이 있다고 표시해준 것 다시 지워줌
			hasQueen[y] = false;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// i열에 이미 퀸이 있다면 실행하지 않음
			if(!hasQueen[i]) {
				// 0 ~ x행에 놓인 퀸의 대각선에 포함되면 실행하지 않음
				int j = 0;
				for (j = 0; j <= x; j++) {
					if(q[j] - (x + 1 - j) == i || q[j] + (x + 1 - j) == i)
						break;
				}
				if(j != x + 1) continue;
				
				// 위의 조건을 모두 통과한 (x + 1, i)에는 퀸을 넣을 수 있음
				queen(x + 1, i);
			}
		}
		
		// 메소드 들어올 때, y열에 퀸이 있다고 표시해준 것 다시 지워줌
		hasQueen[y] = false;
	}


	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		N = Integer.parseInt(br.readLine());
		
		// index행에 있는 퀸이 몇 번째 열에 있는지 담을 배열
		q = new int[N];
		// index열에 퀸이 있는지 확안하는 배열
		hasQueen = new boolean[N];
		
		// 1행의 퀸 위치를 바꿔가며 queen 함수 실행
		for (int i = 0; i < N; i++) {
			queen(0, i);
		}
		
		// 출력
		System.out.println(result);
	}

}
