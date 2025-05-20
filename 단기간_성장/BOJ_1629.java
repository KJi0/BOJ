package 단기간_성장;

/*
 * BOJ 1629 : 곱셈
 * 행렬 제곱 문제를 이해하기 위한... 선행 문제
 * 단순 제곱 문제가 아니라 분할정복 문제! 범위까지 잘 생각해야 한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
	
	static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
	}

	public static long pow(long A, long exp) {
		if (exp == 1)
			return A % C;
		
		long tmp = pow(A, exp / 2);
		
		if (exp % 2 == 1)
			return (tmp * tmp % C) * A % C;
		
		
		return tmp * tmp % C;
	}
}
