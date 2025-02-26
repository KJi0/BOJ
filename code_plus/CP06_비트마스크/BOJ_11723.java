package code_plus.CP06_비트마스크;

/*
 * BOJ 11723 : 집합
 * 비트마스크 기법... 이해하는 데 오래 걸렸다.
 * 잘 숙지해 두자!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			int x = 0;
			
			switch (str) {
			case "add" : { 
				x = Integer.parseInt(st.nextToken());
				S |= (1 << x);
				break; }
			case "remove" : {
				x = Integer.parseInt(st.nextToken());
				S &= ~(1 << x);
				break; }
			case "check" : { 
				x = Integer.parseInt(st.nextToken());
				sb.append((S & (1 << x)) > 0 ? 1 : 0).append("\n");
				break; }
			case "toggle" : {
				x = Integer.parseInt(st.nextToken());
				S ^= (1 << x);
				break; }
			case "all" : { 
				S = (1 << 21) - 1;
				break; }
			case "empty" : {
				S = 0;
				break; }
			}
		}
		System.out.println(sb);
	}
}