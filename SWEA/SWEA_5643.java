package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5643 {
	static int N, M, ans;
	static List<Integer>[] taller;
	static List<Integer>[] smaller;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			taller = new ArrayList[N + 1];
			smaller = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				taller[i] = new ArrayList<>();
				smaller[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // smaller
				int b = Integer.parseInt(st.nextToken()); // taller

				taller[a].add(b);   // a보다 큰 애
				smaller[b].add(a);  // b보다 작은 애
			}

			ans = 0;

			for (int i = 1; i <= N; i++) {
				int cnt = 0;

				visited = new boolean[N + 1];
				cnt += dfs(i, taller);

				visited = new boolean[N + 1];
				cnt += dfs(i, smaller);

				if (cnt == N - 1) ans++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}
	
	static int dfs(int idx, List<Integer>[] stu) {
		int cnt = 0;
		visited[idx] = true;

		for (int s : stu[idx]) {
			if (!visited[s]) {
				cnt++;
				cnt += dfs(s, stu);
			}
		}

		return cnt;
	}
}
