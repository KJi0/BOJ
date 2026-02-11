import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA_5643 {
	static int N, M;
	static ArrayDeque<int[]> stu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			stu = new ArrayDeque<>();
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // smaller
				int b = Integer.parseInt(st.nextToken()); // taller
				stu.add(new int[] {a, b});
			}
			
			
		}
	}
	
	static void dfs() {
		/*
		 * n번 노드가 n번 제외 노드들과 모두 연결되어 있으면 cnt++
		 * arraydeque<int[]> stu에서
		 * stu[i]보다 크면 뒤에 추가하고 작으면 앞에 추가해서
		 * stu[i] size가 N개면 cnt++?
		 * 
		 * ->
		 * 나보다 큰 애들 몇 명?
		 * 작은 애들 몇 명?
		 * 다 더해서 N - 1?
		 */
	}
}
