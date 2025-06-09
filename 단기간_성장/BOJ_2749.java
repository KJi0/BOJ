package 단기간_성장;

/*
 * BOJ 2749 : 피보나치의 수 3
 * 형 변환을 하는 이유는
 * 자바 배열의 최대 크기는 int 범위를 넘어갈 수 없기 때문에
 * 배열 인덱스는 무조건 int여야 함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2749 {
	static long[] fibo;
	static final int pisano = 15 * 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		N %= pisano;
		fibo = new long[(int)N + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= N; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1_000_000;
		}
		
		System.out.println(fibo[(int)N]);
	}
}