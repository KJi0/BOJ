package 단계별로_풀어보기.배열_1차원;

/*
 * BOJ 2562 : 최댓값
 * 최댓값이 어디에 있는지 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < 9; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if (val > max) {
				max = val;
				index = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
