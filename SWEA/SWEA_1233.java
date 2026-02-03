import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {
	/*
	 * SWEA 1233: 사칙연산 유효성 검사
	 * 중위 순회 그래프의 특징:
	 * 피연산자는 모두 리프 노드여야 한다
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean ans = true;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				char op = st.nextToken().charAt(0);
				boolean isDigit = Character.isDigit(op); // 연산자와 피연산자 구분
				
				// 만약 자식 노드가 있다면 op가 연산자여야 함
				if (st.hasMoreElements()) { if (isDigit) ans = false; }
				// 만약 자식 노드가 없다면 op가 피연산자여야 함
				else { if (!isDigit) ans = false; }
			}
			
			System.out.println("#" + t + " " + (ans ? 1 : 0));
		}
	}
}
