package BOJ;

/*
BOJ 5073: 삼각형과 세 변
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0) break;

            if (A == B && B == C)
                sb.append("Equilateral").append('\n');

            else if (A + B <= C || B + C <= A || C + A <= B)
                sb.append("Invalid").append('\n');

            else if (A != B && B != C && A != C)
                sb.append("Scalene").append('\n');

            else
                sb.append("Isosceles").append('\n');
            }

        System.out.println(sb);
    }
}
