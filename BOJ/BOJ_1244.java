package BOJ;

/*
BOJ 1244: 스위치 켜고 끄기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    static int N;
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        switches = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) man(num);
            if (gender == 2) woman(num);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    public static void man(int n) {
        for (int i = 1; n * i <= N; i++)
            switches[n * i] = (switches[n * i] == 1) ? 0 : 1;
    }

    public static void woman(int n) {
        int l = n - 1;
        int r = n + 1;

        while (l > 0 && r <= N) {
            if (switches[l] != switches[r]) break;
            l--;
            r++;
        }
        l++; r--;

        for (int i = l; i <= r; i++) {
            switches[i] = (switches[i] == 1) ? 0 : 1;
        }
    }
}