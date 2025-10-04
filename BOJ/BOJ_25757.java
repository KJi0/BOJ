package BOJ;

/*
BOJ 25757: 임스와 함께하는 미니게임
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        HashSet<String> name = new HashSet<>();
        while (N-- > 0) {
            name.add(br.readLine());
        }

        if (game.equals("Y")) {
            System.out.println(name.size() / 1);
        } else if (game.equals("F")) {
            System.out.println(name.size() / 2);
        } else if (game.equals("O")) {
            System.out.println(name.size() / 3);
        }
    }
}
