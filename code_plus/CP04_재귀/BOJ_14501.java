package code_plus.CP04_재귀;

/*
 * BOJ 14501 : 퇴사
 * 동적 프로그래밍 너무 어렵... ㅠㅠ
 * 복습해야 할 것 같다!!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 2];
		
		for (int i = N; i > 0; i--) {
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
			}
		}
		
		System.out.println(dp[1]);
	}
}