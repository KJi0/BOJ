package 단기간_성장;

/*
 * BOJ 11401 : 이항 계수 3
 * 문제의 요건은 이항 계수 공식을 이용하기만 하면 수의 범위를 넘어가는데
 * 나눗셈에서 모듈러 연산은 성립하지 않는다는 것...
 * 그래서 A/B를 AX 꼴로 만들어 주는 '페르마의 소정리'를 이용해야 했다
 * 어려워...~~~
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401 {
	static long P = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long A = factorial(N);
		long B = factorial(K) * factorial(N - K) % P;
		
		long answer = ((A % P) * (pow(B, P - 2))) % P;
		System.out.println(answer);
	}

	public static long factorial(long N) {
		long fac = 1L;
		
		while (N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		
		return fac;
	}
	
	public static long pow(long A, long exp) {
		if (exp == 1) return A % P;
		
		long tmp = pow(A, exp / 2);
		
		if (exp % 2 == 1)
			return (tmp * tmp % P) * A % P;
		
		return (tmp * tmp) % P;
	}
}