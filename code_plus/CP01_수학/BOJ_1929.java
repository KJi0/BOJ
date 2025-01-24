package code_plus.CP01_수학;

/*
 * BOJ 1929 : 소수 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
	public static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		isPrime = new boolean[N + 1];
		
		for(int i = 0; i < isPrime.length; i++)
			isPrime[i] = true;
		
		is_prime();
		
		for(int i = M; i <= N; i++) {
			if (isPrime[i]) sb.append(i).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void is_prime() {
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i < Math.sqrt(isPrime.length); i++) {
			if (!isPrime[i]) continue;
			
			for(int j = i * i; j < isPrime.length; j += i)
				isPrime[j] = false;
		}
	}
}