package 단기간_성장;

/*
 * BOJ 1865 : 웜홀
 * 벨만-포드 마스터기~
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Road {
	int start;
	int end;
	int cost;
	public Road(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class BOJ_1865 {
	static ArrayList<Road> r;
	static long[] dist;
	static int N, M, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			r = new ArrayList<>();
			dist = new long[N + 1];
			
			for (int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				if (i < M) {
					r.add(new Road(S, E, T));
					r.add(new Road(E, S, T));
				} else
					r.add(new Road(S, E, -T));
			}
			
			if (bellmanford())
				sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}

	public static boolean bellmanford() {
		Arrays.fill(dist, -1);
		dist[1] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < r.size(); j++) {
				int cur = r.get(j).start;
				int next = r.get(j).end;
				int cost = r.get(j).cost;
				
				if (dist[next] > (dist[cur] + cost)) {
					dist[next] = dist[cur] + cost;
					
					if (i == N)
						return true;
				}
			}
		}
		return false;
	}
}