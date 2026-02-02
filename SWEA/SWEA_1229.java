package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1229 {
	/*
	 * SWEA 1229: 암호문2
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
			
			int orderCnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < orderCnt; i++) {
				String order = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (order.equals("I")) {
					while (y-- > 0)
					list.add(x++, Integer.parseInt(st.nextToken()));
				}
				
				else {
					while (y-- > 0)
						list.remove(x);
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			} 
			System.out.println();
		}
	}
}
