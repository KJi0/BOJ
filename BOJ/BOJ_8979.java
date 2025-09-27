package BOJ;

/*
BOJ 8979: 올림픽
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8979 {
    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countries.add(new Country(n, g, s, b));
        }

        countries.sort((c1, c2) -> {
             if (c1.gold == c2.gold) {
                if (c1.silver == c2.silver) {
                    return c2.bronze - c1.bronze;
                }
                return c2.silver - c1.silver;
            }
             return c2.gold - c1.gold;
        });

        int rank = 1;
        for (int i = 0; i < countries.size(); i++) {
            if (i > 0 && !isSameRank(countries.get(i), countries.get(i - 1))) {
                rank = i + 1;
            }
            if (countries.get(i).num == K) {
                System.out.println(rank);
                break;
            }
        }
    }

    public static boolean isSameRank (Country c1, Country c2) {
        return c1.gold == c2.gold && c1.silver == c2.silver &&
                c1.bronze == c2.bronze;
    }
}
