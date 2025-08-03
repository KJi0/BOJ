package BOJ;

/*
BOJ 20056: 마법사 상어와 파이어볼
하... ㅋㅋ
생성자 매개변수 순서 잘못 쓴 거 못 찾아서 하루를 날렸다...
다음부터는 그러지 말자...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056 {
    static class Ball {
        int x, y, m, s, d;
        public Ball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Ball> map[][];
    static ArrayList<Ball> balls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Queue[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            balls.add(new Ball(r, c, m, s, d));
        }

        while (K-- > 0) {
            move();
            divide();
        }

        int answer = 0;
        for (Ball b : balls) {
            answer += b.m;
        }

        System.out.println(answer);
    }

    public static void move() {
        for (Ball cur : balls) {
            cur.x = (N + cur.x + dx[cur.d] * (cur.s % N)) % N;
            cur.y = (N + cur.y + dy[cur.d] * (cur.s % N)) % N;
            map[cur.x][cur.y].add(cur);
        }
    }

    public static void divide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 2) {
                    int m_sum = 0, s_sum = 0;
                    int cnt = map[i][j].size();
                    boolean allOdd = true, allEven = true;

                    while (!map[i][j].isEmpty()) {
                        Ball cur = map[i][j].poll();
                        m_sum += cur.m;
                        s_sum += cur.s;

                        if (cur.d % 2 == 0)
                            allOdd = false;
                        else
                            allEven = false;

                       balls.remove(cur);
                    }

                    int newM = m_sum / 5;
                    int newS = s_sum / cnt;

                    if (newM == 0) continue;

                    if (allOdd || allEven) {
                        for (int k = 0; k < 8; k += 2) {
                            balls.add(new Ball(i, j, newM, newS, k));
                        }
                    } else {
                        for (int k = 1; k < 8; k += 2) {
                            balls.add(new Ball(i, j, newM, newS,k));
                        }
                    }
                } else
                    map[i][j].clear();
            }
        }
    }
}
