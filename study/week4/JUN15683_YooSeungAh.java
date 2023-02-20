import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUN15683_YooSeungAh {
	
	static int N;
	static int M;
	static String[][] arr;
	static ArrayList<int[]> cctvs;
	static int result = (int) 10e9;
	
	// d 방향을 감시
	private static void c(Stack<int[]> stack, int d, int x, int y) {
		// 상, 우, 하, 좌
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		while(nx >= 0 && nx < N && ny >= 0 && ny < M && !arr[nx][ny].equals("6")) {
			if(arr[nx][ny].equals("0")) {
				arr[nx][ny] = "#";
				stack.add(new int[] {nx, ny});
			}
			nx += dx[d];
			ny += dy[d];
		}
	}
	
	// 전달 받은 stack에 들어있는 인덱스에 해당하는 곳을 다시 '0'으로 바꿔줌
	private static void returnZero(Stack<int[]> stack) {
		while(!stack.empty()) {
			int[] tmp = stack.pop();
			arr[tmp[0]][tmp[1]] = "0";
		}
	}
	
	// d = 0, 1, 2, 3
	private static void cctv1(Stack<int[]> stack, int d, int x, int y) {
		c(stack, d, x, y);
	}
	
	// d = 0, 1
	private static void cctv2(Stack<int[]> stack, int d, int x, int y) {
		if(d == 0 || d == 1) {
			c(stack, d, x, y);
			c(stack, d + 2, x, y);
		}
	}
	
	// d = 0, 1, 2, 3
	private static void cctv3(Stack<int[]> stack, int d, int x, int y) {
		c(stack, d, x, y);
		c(stack, (d + 1) % 4, x, y);
	}
	
	// d = 0, 1, 2, 3
	private static void cctv4(Stack<int[]> stack, int d, int x, int y) {
		c(stack, d, x, y);
		c(stack, (d + 1) % 4, x, y);
		c(stack, (d + 2) % 4, x, y);
	}
	
	private static void cctv5(Stack<int[]> stack, int d, int x, int y) {
		if(d == 0) {
			c(stack, 0, x, y);
			c(stack, 1, x, y);
			c(stack, 2, x, y);
			c(stack, 3, x, y);
		}
	}
	
	private static void cctv(int idx) {
		if(idx == cctvs.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j].equals("0"))
						count++;
				}
			}
			result = result < count ? result : count;
			return;
		}
		
		int k = cctvs.get(idx)[0];
		int x = cctvs.get(idx)[1];
		int y = cctvs.get(idx)[2];
		
		// '#'으로 만든 곳의 인덱스를 넣어둘 stack
		Stack<int[]> stack = new Stack<>();
		for (int d = 0; d < 4; d++) {
			if(k == 1) cctv1(stack, d, x, y);
			else if(k == 2) cctv2(stack, d, x, y);
			else if(k == 3) cctv3(stack, d, x, y);
			else if(k == 4) cctv4(stack, d, x, y);
			else if(k == 5) cctv5(stack, d, x, y);
			
			cctv(idx + 1);
			
			returnZero(stack);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// N x M 크기의 2차원 배열 선언 & 정보 입력
		// CCTV 정보 저장
		arr = new String[N][M];
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) { // cctv라면 정보와 위치 저장
				String tmp = st.nextToken();
				arr[i][j] = tmp;
				if(tmp.equals("1")) cctvs.add(new int[] {1, i, j});
				else if(tmp.equals("2")) cctvs.add(new int[] {2, i, j});
				else if(tmp.equals("3")) cctvs.add(new int[] {3, i, j});
				else if(tmp.equals("4")) cctvs.add(new int[] {4, i, j});
				else if(tmp.equals("5")) cctvs.add(new int[] {5, i, j});
			}
		}
		
		cctv(0);
		
		System.out.println(result);
	}

}