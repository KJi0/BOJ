package code_plus.CP01_수학;

/*
 * BOJ 6588 : 골드바흐의 추측
 * 
 * 기본 출력에서 1080ms나 나오길래
 * StringBuilder로 바꿨더니 508ms...
 * 절반이나 줄었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
	public static final int MAX = 1000000;
	public static boolean[] isPrime = new boolean[MAX + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n;

		is_prime();
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			
			boolean ans = false;
			
			for(int i = 2; i <= n / 2; i++) {
				if (isPrime[i] && isPrime[n - i]) {
					sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append('\n');
					ans = true;
					break;
				}
			}
			if (!ans)
				sb.append("Goldbach's conjecture is wrong.").append('\n');
		}
		System.out.print(sb);
	}

	public static boolean[] is_prime() {
		
		for(int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;
		
		for(int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if(!isPrime[i]) continue;
				for(int j = i * i; j < isPrime.length; j += i)
					isPrime[j] = false;
		}
		return isPrime;
	}
}