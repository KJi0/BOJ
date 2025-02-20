package code_plus.CP04_재귀;

/*
 * BOJ 14889 : 스타트와 링크
 * 삼성 SW 역량 테스트 기출 중 하나라고 한다.
 * 어려운데 ㅠ... 복습하자!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 0);
		System.out.println(min);
	}
	
	public static void dfs(int idx, int cnt) {
		if (cnt == N / 2) {
			diff();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					dfs(i + 1, cnt + 1);
					visit[i] = false;
				}
			}
		}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (visit[i] == true && visit[j] == true) {
					start += arr[i][j];
					start += arr[j][i];
				}
				
				else if (visit[i] == false && visit[j] == false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		int sub = Math.abs(start - link);
		
		if (sub == 0) {
			System.out.println(sub);
			System.exit(0);
		}
		
		min = Math.min(sub, min);
	}
}