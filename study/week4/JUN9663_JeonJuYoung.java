package study.week4;

import java.util.*;
import java.io.*;

public class JUN9663_JeonJuYoung {

	static int[] arr;
	static int n;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		solve(0);
		System.out.println(cnt);
	}
	private static void solve(int depth) {
		if(depth==n) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				solve(depth+1);
			}
		}
	}
	private static boolean possible(int col) {
		for(int i = 0; i < col; i++) {
			//행에 일치하는게 있는지 판별
			if(arr[i]==arr[col]) {
				return false;
			}
			//대각선 판별
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	
}

//https://infodon.tistory.com/61