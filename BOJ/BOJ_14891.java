package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[] d;
    static int[][] gear = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        while (k--> 0) {
            st = new StringTokenizer(br.readLine());
            int gearN = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            d = new int[4];

            d[gearN] = dir;
            checkDir(gearN);
            gearTurn();
        }

        int ans = 0;
        if (gear[0][0] == 1) ans += 1;
        if (gear[1][0] == 1) ans += 2;
        if (gear[2][0] == 1) ans += 4;
        if (gear[3][0] == 1) ans += 8;
        System.out.println(ans);
    }

    static void checkDir(int gearN) {
        for (int i = gearN - 1; i >= 0; i--) {
            if (gear[i][2] != gear[i + 1][6]) {
                d[i] = -d[i + 1];
            } else
                break;
        }

        for (int i = gearN + 1; i < 4; i++) {
            if (gear[i - 1][2] != gear[i][6]) {
                d[i] = -d[i - 1];
            } else
                break;
        }
    }

    static void gearTurn() {
        int tmp = 0;

        for (int i = 0; i < 4; i++) {
            if (d[i] == 1) {
                tmp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = tmp;
            }

            if (d[i] == -1) {
                tmp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = tmp;
            }
        }
    }
}