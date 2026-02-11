package SWEA;

/*
 * SWEA 5648: 원자 소멸 시뮬레이션
 * 너무 어렵다 ㅠ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA_5648 {
	static int N, sum;
	static int[][] map = new int[4001][4001];
	static ArrayDeque<Node> atom;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			atom = new ArrayDeque<>();
			
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				
				map[y][x] = energy;
				atom.addLast(new Node(x, y, dir, energy));
			}
			
			bfs();
			System.out.println("#" + t + " " + sum);
		}
	}
	
	static void bfs() {
		while (!atom.isEmpty()) {
			Node cur = atom.pollFirst();
			
			if (map[cur.y][cur.x] != cur.energy) {
				sum += map[cur.y][cur.x];
				map[cur.y][cur.x] = 0;
				continue;
			}
			
			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];
			
			if (nx < 0 || nx > 4000 || ny < 0 || ny > 4000) continue;
			
			if (map[ny][nx] == 0) atom.addLast(new Node(nx, ny, cur.dir, cur.energy));
			
			map[ny][nx] += cur.energy;
				
			map[cur.y][cur.x] = 0;
		}
	}
	
	static class Node {
		int x;
		int y;
		int dir;
		int energy;
		
		public Node(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}
}
