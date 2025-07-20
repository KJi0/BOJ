package BOJ;

/*
BOJ 21608: 상어 초등학교
이게 골드5 문제라니
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_21608 {
    static int N, score = 0;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashMap<Integer, int[]> students = new HashMap<>();

    static class Seat {
        int x;
        int y;
        int emptyCnt;
        int likeCnt;
        public Seat(int x, int y, int emptyCnt, int likeCnt) {
            this.x = x;
            this.y = y;
            this.emptyCnt = emptyCnt;
            this.likeCnt = likeCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());

            students.put(num, new int[] {s1, s2, s3, s4});
            allocateSeat(num);
        }

        getScore();
        System.out.println(score);
    }

    public static void allocateSeat(int num) {
        int[] likes = students.get(num);
        ArrayList<Seat> seats = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int emptyCnt = 0;
                int likeCnt = 0;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (map[nx][ny] == 0) emptyCnt++;

                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == likes[j]) likeCnt++;
                        }
                    }
                }
                seats.add(new Seat(x, y, emptyCnt, likeCnt));
            }
        }

        seats.sort((s1, s2) -> {
            if (s1.likeCnt == s2.likeCnt) {
                if (s1.emptyCnt == s2.emptyCnt) {
                    if (s1.x == s2.x) {
                        return s1.y - s2.y;
                    }
                    return s1.x - s2.x;
                }
                return s2.emptyCnt - s1.emptyCnt;
            }
            return s2.likeCnt - s1.likeCnt;
        });

        for (Seat seat : seats) {
            if (map[seat.x][seat.y] != 0) continue;
            map[seat.x][seat.y] = num;
            return;
        }
    }

    public static void getScore() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int cnt = 0;
                int[] likes = students.get(map[x][y]);

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == likes[j]) cnt++;
                        }
                    }
                }

                switch (cnt) {
                    case 1: score += 1; break;
                    case 2: score += 10; break;
                    case 3: score += 100; break;
                    case 4: score += 1000; break;
                }
            }
        }
    }
}