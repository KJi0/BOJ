package code_plus.CP04_재귀;

/*
 * BOJ 2529 : 부등호
 * 긁적... ArrayList에 익숙해질 차례
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2529 {
	static int k;
	static String[] arr;
	static boolean[] visit;
	static ArrayList<String> result = new ArrayList<>();
	
	public static void dfs(int idx, int cnt, String s) {
		if (cnt == k) {
			result.add(s);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				if ((arr[cnt].equals("<") && idx < i) ||
				(arr[cnt].equals(">") && idx > i)) {
					visit[i] = true;
					dfs(i, cnt + 1, s + i);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		arr = new String[k];
		visit = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < k; i++)
			arr[i] = st.nextToken(); 
		
		for (int i = 0; i < 10; i++) {
			visit[i] = true;
			dfs(i, 0, i + "");
			visit[i] = false;
		}
		
		System.out.println(result.get(result.size() - 1));
		System.out.println(result.get(0));
	}

}
