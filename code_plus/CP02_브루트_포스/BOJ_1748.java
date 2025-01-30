package code_plus.CP02_브루트_포스;

/*
 * BOJ 1748 : 수 이어 쓰기 1
 * 어렵다 어려워... ㅠ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 1; i <= N; i *= 10)
			sum += N - i + 1;
		
		System.out.print(sum);
	}
}