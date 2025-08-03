package BOJ;

/*
BOJ 14890: 경사로
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int path = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) path++;
            if (checkCol(i)) path++;
        }

        System.out.println(path);
    }

    public static boolean checkRow(int r) {
        boolean[] isEmpty = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[r][i] - map[r][i + 1];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) { // 다음이 한 층 높다
                for (int j = 0; j < L; j++) {
                    if (i - j < 0) return false;
                    if (isEmpty[i - j]) return false;
                    if (map[r][i] != map[r][i - j]) return false;
                    isEmpty[i - j] = true;
                }
            }
            else if (diff == 1) { // 다음이 한 층 낮다
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N) return false;
                    if (isEmpty[i + j]) return false;
                    if (map[r][i + 1] != map[r][i + j]) return false;
                    isEmpty[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean checkCol(int c) {
        boolean[] isEmpty = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][c] - map[i + 1][c];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) { // 다음이 한 층 높다
                for (int j = 0; j < L; j++) {
                    if (i - j < 0) return false;
                    if (isEmpty[i - j]) return false;
                    if (map[i][c] != map[i - j][c]) return false;
                    isEmpty[i - j] = true;
                }
            }
            else if (diff == 1) { // 다음이 한 층 낮다
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N) return false;
                    if (isEmpty[i + j]) return false;
                    if (map[i + 1][c] != map[i + j][c]) return false;
                    isEmpty[i + j] = true;
                }
            }
        }
        return true;
    }
}