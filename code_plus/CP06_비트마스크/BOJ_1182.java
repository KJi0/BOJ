package code_plus.CP06_비트마스크;

/*
 * BOJ 1182 : 부분수열의 합
 * 신박한 dfs 문제...
 * 공집합은 제외해야 하는 부분수열 주의하기!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int N, S, cnt;
	static int[] arr;
	
	public static void dfs(int idx, int sum) {
		if (idx == N) {
			if (sum == S) cnt++;
			return;
		}
		
		dfs(idx + 1, sum + arr[idx]); // 현재 원소를 선택함
		
		dfs(idx + 1, sum); // 현재 원소를 선택하지 않음
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		cnt = 0;
		dfs(0, 0);
		
		if (S == 0) cnt--;
		System.out.println(cnt);
	}
}