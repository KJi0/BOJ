import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {
	/*
	 * SWEA 9229: 한빈이와 Spot Mart
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken()); 
			
			Arrays.sort(arr);
			
			int s = 0; int e = N - 1; int max = -1;
			while (s < e) {
				int sum = arr[s] + arr[e];
				
				if (sum > M) e--;
				else { max = Math.max(max, sum); s++; }
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}