package BOJ;

/*
BOJ 1193: 분수찾기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int prev_sum = 0, cnt = 1;
        while (true) {
            if (X <= prev_sum + cnt) {
                if (cnt % 2 == 1) { // 홀수
                    System.out.print((cnt - (X - prev_sum - 1)) + "/" + (X - prev_sum));
                    break;
                } else {
                    System.out.print((X - prev_sum) + "/" + (cnt - (X - prev_sum - 1)));
                    break;
                }
            } else {
                prev_sum += cnt;
                cnt++;
            }
        }
    }
}
