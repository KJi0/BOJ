package BOJ;

/*
BOJ 2566: 최댓값
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int r = -1;
        int c = -1;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num > max) {
                    max = num;
                    r = i; c = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(r + " " + c);
    }
}
