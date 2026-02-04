import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 1210: Ladder1
 * 한 방향으로만 탐색하므로 break 써야 함
 */

public class SWEA_1210 {
	static Node end;
	static int[][] map;
	
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			map = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (i == 99 && map[99][j] == 2) end = new Node(99, j);
				}
			}
			
			System.out.println("#" + t + " " + bfs(end.x, end.y));
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (cur.x == 0) return cur.y;
			
			for (int d = 0; d < 3; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
				if (map[nx][ny] != 1) continue;
				
				map[nx][ny] = 3;
				q.add(new Node(nx, ny));
				break;
			}
		}
		
		return 0;
	}
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}