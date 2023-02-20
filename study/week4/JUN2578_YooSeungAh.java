import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class JUN2578_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 빙고판 해쉬맵에 입력
		HashMap<Integer, int[]> hm = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				hm.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
			}
		}
		
		// 빙고판 정보
		boolean[][] info = new boolean[6][6];
		
		// 사회자가 부른 순서대로 저장.
		StringTokenizer[] stArr = new StringTokenizer[5];
		for (int i = 0; i < 5; i++) {
			stArr[i] = new StringTokenizer(br.readLine());
		}
		
		// 몇 번째에 빙고 외치는지 구하기
		int result = 0;
		int count = 0;
for1:	for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(stArr[i].nextToken());
				int x = hm.get(num)[0];
				int y = hm.get(num)[1];
				info[x][y] = true;
				
				// 가로줄 확인
				boolean check = true;
				for(int k = 0; k < 5; k++) {
					if(!info[x][k]) {
						check = false;
						break;
					}
				}
				if(check) count++;
				
				// 세로줄 확인
				check = true;
				for(int k = 0; k < 5; k++) {
					if(!info[k][y]) {
						check = false;
						break;
					}
				}
				if(check) count++;
				
				// 대각선(위->아래) 확인
				if(x == y) {
					check = true;
					for (int k = 0; k < 5; k++) {
						if(!info[k][k]) {
							check = false;
							break;
						}
					}
					if(check) count++;
				}
				
				// 대각선(아래->위) 확인
				if(x + y == 4) {
					check = true;
					for (int k = 0; k < 5; k++) {
						if(!info[k][4 - k]) {
							check = false;
							break;
						}
					}
					if(check) count++;
				}
				
				if(count >= 3) {
					result = 5 * i + (j + 1);
					break for1;
				}
			}
		}
		
		System.out.println(result);
	}

}