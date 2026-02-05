package BOJ;

/*
 * BOJ 2023: 신기한 소수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(0, 0);
	}

	public static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	static void dfs(int num, int depth) {
		if (depth == N) {
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			int tmp = num * 10 + i;
			if (isPrime(tmp)) dfs(tmp, depth + 1);
		}
	}
}