package com.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUN2616 {
	/*
	 * 소형 기관차
	 * 원래 대형 기관차가 N 개의 객차를(안에 사람은 people <= 100) 끌고 가는데 고장이남 (  N <= 50_000 )
	 * 3대의 소형 기관차로 나눠서 가기로 함
	 * 소형 기관차는 M개의 객차만 끌고 갈 수 있음 ( M < N/3)
	 * 이 때 가장 많이 데려가는 경우를 찾아서 손님의 수를 반환해야함.
	 * 
	 * */
	
	static int N, M, max;
	static int[] people;
	static int[][] sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 객차 수
		people = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < people.length; i++) {
			people[i] = people[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
		M = Integer.parseInt(br.readLine());
		sum = new int[4][N+1];
		
		for(int i = 1; i < 4; i++) {
			for (int j = i * M; j < sum[i].length; j++) {
				sum[i][j] = Math.max(sum[i][j-1], sum[i-1][j-M] + (people[j] - people[j -M]));
			}
		}
		System.out.println(sum[3][N]);
	}
}
