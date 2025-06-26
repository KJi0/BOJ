package 단기간_성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int num;
	int cnt;
	
	public Pair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class BOJ_1039 {
	static int N, K, len;
	static int ans = -1;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		str = Integer.toString(N);
		len = str.length();
		
		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[1000001][K + 1];
		
		q.add(new Pair(N, 0));
		visited[N][0] = true;
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			if (p.cnt == K) {
				ans = Math.max(ans, p.num);
				continue;
			}
			
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					int swapNum = swap(p.num, i, j);
					
					if (swapNum != -1 && !visited[swapNum][p.cnt + 1]) {
						q.add(new Pair(swapNum, p.cnt + 1));
						visited[swapNum][p.cnt + 1] = true;
					}
				}
			}
		}
	}
	
	public static int swap(int n, int i, int j) {
		char[] c = String.valueOf(n).toCharArray();
		
		if (i == 0 && c[j] == '0') return -1;
		
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
		
		return Integer.parseInt(String.valueOf(c));
	}
}
