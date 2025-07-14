package BOJ;

/*
BOJ 20055: 컨베이어 벨트 위의 로봇
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int N, K, level = 0;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N + 1];
        robot = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        rotate();
        System.out.println(level);
    }

    public static void rotate() {
        while (true) {
            level++;

            int tmp = A[2 * N];
            for (int i = 2 * N; i > 1; i--) {
                A[i] = A[i - 1];
            }
            A[1] = tmp;

            for (int i = N; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[N] = false;
            robot[1] = false;

            for (int i = N; i > 1; i--) {
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    A[i]--;
                    robot[i - 1] = false;
                    robot[i] = true;
                    robot[N] = false;
                }
            }

            if (A[1] > 0) {
                robot[1] = true;
                A[1]--;
            }

            int cnt = 0;
            for (int i = 1; i <= 2 * N; i++) {
                if (A[i] == 0)
                    cnt++;
            } if (cnt >= K) break;
        }
    }
}
