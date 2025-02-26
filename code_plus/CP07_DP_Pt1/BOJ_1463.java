package code_plus.CP07_DP_Pt1;

/*
 * BOJ 1463 : 1로 만들기
 * 경우의 수 생각하기... 어렵다. 어렵다 ㅠ
 * 코드는 이리 간결한데......
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
	static Integer[] dp;
	
	public static int recur(int X) {
		
		if (dp[X] == null) {
			
			if (X % 6 == 0) {
				dp[X] = Math.min(recur(X - 1), Math.min(recur(X / 3), recur(X / 2))) + 1;
			}
			else if (X % 3 == 0) {
				dp[X] = Math.min(recur(X / 3), recur(X - 1)) + 1;
			}
			else if (X % 2 == 0) {
				dp[X] = Math.min(recur(X / 2), recur(X - 1)) + 1;
			}
			else
				dp[X] = recur(X - 1) + 1;
		}
		
		return dp[X];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		
		System.out.print(recur(N));
	}
}