package BOJ;

/*
BOJ 1009: 분산처리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = 1;
            for (int i = 0; i < b; i++) {
                ans = (ans * a) % 10;
            }

            if (ans == 0) ans = 10;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
