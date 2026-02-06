package BOJ;

/*
 * BOJ 1194: 달이 차오른다, 가자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	static int N, M;
	static char[][] maze;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		
		int startX = 0; int startY = 0;
		
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == '0') { 
					startX = i; startY = j; 
				}
			}
		}
		
		System.out.println(bfs(startX, startY));
	}

	static int bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64];
	
		q.add(new Node(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (maze[cur.x][cur.y] == '1') {
				return cur.move;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nkey = cur.key;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (maze[nx][ny] == '#') continue;

				char next = maze[nx][ny];
				
				// 키 획득
				if ('a' <= next && next <= 'f') {
					nkey |= (1 << (next - 'a'));
				}
				
				// 키 있는지 확인
				if ('A' <= next && next <= 'F') {
					if ((nkey & (1 << (next - 'A'))) == 0) continue;
				}
				
				// 키가 있거나 빈 칸이라면
				if (visited[nx][ny][nkey]) continue;
				visited[nx][ny][nkey] = true;
				q.add(new Node(nx, ny, nkey, cur.move + 1));
			}
		}
		return -1;
	}
	
	static class Node {
		int x;
		int y;
		int key;
		int move;
		
		public Node(int x, int y, int key, int move) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.move = move;
		}
	}
}