package BOJ;

/*
BOJ 20125: 쿠키의 신체 측정
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20125 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N;
    static int hx, hy, lArm, rArm, waist, lLeg, rLeg;
    static char[][] map;
    static List<int[]> cookie = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j];

                if (map[i][j] == '*')
                    cookie.add(new int[]{i, j});
            }
        }

        // 심장 찾기
        for (int[] pos : cookie) {
            if (isHeart(pos[0], pos[1])) {
                hx = pos[0];
                hy = pos[1];
                break;
            }
        }
        sb.append(hx + 1).append(" ").append(hy + 1);
        sb.append("\n");

        // 왼팔 길이
        int r = hx;
        int c = hy - 1;
        while (isRange(r, c) && map[r][c] == '*') {
            lArm++;
            c--;
        }
        sb.append(lArm).append(" ");

        // 오른팔 길이
        r = hx;
        c = hy + 1;
        while (isRange(r, c) && map[r][c] == '*') {
            rArm++;
            c++;
        }
        sb.append(rArm).append(" ");

        // 허리 길이
        int wx = hx + 1;
        int wy = hy;
        while (isRange(wx, wy) && map[wx][wy] == '*') {
            waist++;
            wx++;
        }
        sb.append(waist).append(" ");

        // 왼다리 길이
        r = wx;
        c = wy - 1;
        while (isRange(r, c) && map[r][c] == '*') {
            lLeg++;
            r++;
        }
        sb.append(lLeg).append(" ");

        // 오른다리 길이
        r = wx;
        c = wy + 1;
        while (isRange(r, c) && map[r][c] == '*') {
            rLeg++;
            r++;
        }
        sb.append(rLeg).append(" ");

        System.out.println(sb);
    }

    public static boolean isHeart(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isRange(nx, ny)) return false;
            if (map[nx][ny] != '*') return false;
        }
        return true;
    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && y >= 0 && y < N;
    }
}
