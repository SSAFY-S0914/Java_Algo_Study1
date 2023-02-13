package com;
import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;
public class JUN9663 {
	static Scanner sc = new Scanner(System.in);
	static int count = 0; // n개의 queen을 놓을 수 있는 경우
	static int[] queen;
	
	public static void main(String args[]) throws Exception
	{
		int n = sc.nextInt(); // 맵 크기 , 놓아야 하는 퀸 갯수
		queen = new int[n]; //queen이 놓아지는 y 좌표(열)
			
		count = 0;
		piece(0);
			
		System.out.println(count);
	}
	
	public static void piece(int hight) // 한 개 씩 놓아보기
	{
		if(hight == queen.length) // n개가 놓아지면 
		{
			count++;
			return;
		}
		
		for(int i = 0; i < queen.length; i++)
		{
			queen[hight] = i;
			if(check(hight))
			{
				piece(hight+1);
			}
		}
	}
	
	public static Boolean check(int x) // 놓을 수 있는지 확인
	{
		for(int i =0; i < x;i++)
		{
			if(queen[i] == queen[x]) // 같은 열에 있는지
			{
				return false;
			}
			else if(Math.abs(x-i) == Math.abs(queen[x]-queen[i])) //대각선에 있는지
			{
				return false;
			}
		}
		return true;
	}
}
