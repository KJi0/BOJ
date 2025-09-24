package BOJ;

/*
BOJ 5585: 거스름돈
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(br.readLine());

        int change = 1000 - cost;
        int cnt = 0;

        int n = 500;
       while(true) {
           if (change == 0) break;

           if (change / n > 0) {
               cnt += change / n;
               change %= n;
           }
           n /= 5;

           if (change / n > 0) {
               cnt += change / n;
               change %= n;
           }
           n /= 2;
       }

        System.out.println(cnt);
    }
}
