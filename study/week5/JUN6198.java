package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
	int city, cost;

	public Bus(int city, int cost) {
		this.city = city;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Bus o) { // city가 낮은 번호인 순으로
		return city - o.city;
	}
}

public class JUN6198 {
	static int N,M; 
	static boolean[] isSelected;
	static List<Bus>[] route;	
	static int[][] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		route = new ArrayList[N+1];
		result = new int[N+1][N+1];
		for(int i =0; i <= N; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);			
		}
		
		for (int i = 1; i <= N; i++) {
			route[i] = new ArrayList<Bus>();
		}
		
		for (int i = 0; i < M; i++) { // 도시 여행 비용 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 버스 비용
			route[a].add(new Bus(b, c));
		}
		
//		for(int i = 1; i < route.length; i++) {			
//			System.out.println(" ");
//			for(int j = 0; j < route[i].size(); j++) {
//				System.out.print("< "+route[i].get(j).city+ " "+route[i].get(j).cost+" >");
//			}
//		}System.out.println();
		
		for(int i = 1; i <= N; i++) {			
			sum(i);
			for(int j = 1; j < result[i].length; j++) {
				sb.append(result[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
		
	public static void sum(int s) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(s, 0));
		result[s][s] = 0;
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println("<< "+pq.peek().city + "," + pq.peek().cost+" >>");
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			int x = now.city;
			for (int i = 0; i < route[x].size(); i++) {
				int next = route[x].get(i).city;
				int next_cost = route[x].get(i).cost; 
				//System.out.println("<< "+ next + "," + next_cost+" >>");
				if(result[s][next] > now.cost + next_cost) {
					result[s][next] = now.cost + next_cost;
//					System.out.println("--------------------------------------");
//					System.out.println(next+" 까지 비용은 : "+result[s][next]);
					pq.add(new Bus(next, result[s][next]));
				}
			}
		}
		for(int i = 1; i < result[s].length; i++) {
			result[s][i] = result[s][i] == Integer.MAX_VALUE?0:result[s][i]; 
		}
	}
}
