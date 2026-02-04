import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	/*
	 * SWEA 6808: 규영이와 인영이의 카드게임
	 */
	
	static boolean[] visited;
	static int[] gyCard;
	static int[] iyCard;
	
	static int gyScore, iyScore;
	static int gyWin = 0;
	static int iyWin = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			gyWin = iyWin = 0;
			
			gyCard = new int[10];
			iyCard = new int[10];
			visited = new boolean[10];
			
			boolean[] check = new boolean[19];
			
			for (int i = 0; i < 9; i++) {
				gyCard[i] = Integer.parseInt(st.nextToken());
				check[gyCard[i]] = true;
			}
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (check[i]) continue;
				iyCard[idx++] = i;
			}
			
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + gyWin + " " + iyWin);
		}
	}
	
	public static void dfs(int depth, int gyScore, int iyScore) {
		if (depth == 9) {
			if (gyScore > iyScore) gyWin++;
			else iyWin++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			
			int sum = gyCard[depth] + iyCard[i];
			if (gyCard[depth] > iyCard[i]) dfs(depth + 1, gyScore + sum, iyScore);
			else dfs(depth + 1, gyScore, iyScore + sum);
			
			visited[i] = false;
		}
	}

}
