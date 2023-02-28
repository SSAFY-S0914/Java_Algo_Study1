import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUN9252_YooSeungAh {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] string1 = br.readLine().toCharArray();
		char[] string2 = br.readLine().toCharArray();
		
		// LCS 길이를 담을 배열
		int[][] arr = new int[string1.length + 1][string2.length + 1];
		for (int i = 1; i <= string1.length; i++) {
			for (int j = 1; j <= string2.length; j++) {
				if(string1[i - 1] == string2[j - 1]) arr[i][j] = arr[i - 1][j - 1] + 1;
				else arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		
		if(arr[string1.length][string2.length] == 0) sb.append(0); // 부분 문자열의 길이가 0이면 0만 출력
		else {
			int resultSize = arr[string1.length][string2.length]; // 가장 긴 부분 문자열의 길이
			sb.append(resultSize + "\n"); // 문자열 길이 출력에 담자주고
			char[] result = new char[resultSize];// 가장 긴 부분 문자열을 담아줄 배열
			int idx = resultSize - 1; // 현재 배열에 넣을 위치
			int x = string1.length, y = string2.length;
			while(x >= 1 && y >= 1) {
				if(arr[x - 1][y] == arr[x][y]) x--; // 위쪽의 lcs가 같다면 그쪽으로
				else if(arr[x][y - 1] == arr[x][y]) y--; // 왼쪽의 lcs가 같다면 그쪽으로
				else { // 왼쪽 위쪽의 lcs가 모두 작다면
					result[idx--] = string1[x - 1]; // 현재 문자열을 가장 긴 부분 문자열 배열에 담아주고
					x--; // 대각선 위치로
					y--;
				}
			}
			sb.append(String.valueOf(result));
		}
		
		System.out.println(sb);
	}

}