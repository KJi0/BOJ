package 단기간_성장;

/*
 * BOJ 11657 : 타임머신
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int cost;
	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class BOJ_11657 {
	static int N, M;
	static Edge[] e;
	static long[] dist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		e = new Edge[M];
		dist = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			e[i] = new Edge(A, B, C);
		}
		
		if (bellmanford(1)) System.out.println("-1");
		
		else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) System.out.println("-1");
				else System.out.println(dist[i]);
			}
		}
	}

	public static boolean bellmanford(int start) {
		dist[start] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int cur = e[j].start;
				int next = e[j].end;
				int cost = e[j].cost;
				
				if (dist[cur] == INF) continue;
				
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
