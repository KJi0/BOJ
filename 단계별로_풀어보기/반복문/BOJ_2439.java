package 단계별로_풀어보기.반복문;

/**
 * BOJ 2439 : 별 찍기 - 2
 * 별을 찍는 문제 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++)
				sb.append(' ');
			for (int k = 0; k < i; k++)
				sb.append('*');
	
			sb.append('\n');
		}
		System.out.println(sb);
	}
}