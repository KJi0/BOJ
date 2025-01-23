package code_plus.CP01_수학;

/*
 * BOJ 1978 : 소수 찾기
 * 두 가지 방법으로 풀이 (에라토스테네스의 체, 제곱근)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {

	/* Solution 1. 에라토스테네스의 체
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(is_prime(num) == 0)
				cnt++;
		}
		
		System.out.print(cnt);
	}

	public static int is_prime(int num) {
		int max = 1000;
		int[] isPrime = new int[max + 1];
		
		isPrime[0] = isPrime[1] = 1;
		
		for(int i = 2; i <= Math.sqrt(max); i++) {
			if (isPrime[i] == 0) {
				for(int j = i * i; j < max + 1; j += i)
					isPrime[j] = 1;
			}
		}
		
		if (isPrime[num] == 0)
			return 0;
		
		return 1;
	} */
	
	// Solution 2. 제곱근
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;
			
			if (num == 1) continue;
			
			for(int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) cnt++;
		}
		System.out.print(cnt);
	}
}
