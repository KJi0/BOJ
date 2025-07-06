package BOJ;

/*
BOJ 15686: 치킨 배달
 */

import java.io.*;
import java.util.*;

public class BOJ_15686 {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] open;
    static ArrayList<Point> chicken = new ArrayList<Point>();
    static ArrayList<Point> house = new ArrayList<Point>();

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) house.add(new Point(i, j));
                if (map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) +
                                Math.abs(house.get(i).y - chicken.get(j).y);

                        min = Math.min(min, dist);
                    }
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}