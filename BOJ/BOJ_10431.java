package BOJ;

/*
BOJ 10431: 줄세우기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431 {
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            height = new int[20];

            for (int i = 0; i < 20; i++)
                height[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (height[j] > height[i]) {
                        cnt++;
                    }
                }
            }

            sb.append(T).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}