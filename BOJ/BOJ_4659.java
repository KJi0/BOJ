package BOJ;

/*
BOJ 4659: 비밀번호 발음하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        char c;
        char prev;
        boolean isAcceptable;

        while (!(str = br.readLine()).equals("end")) {
            prev = '.';
            int cnt = 0;
            isAcceptable = false;

            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);

                if (isVowel(c)) isAcceptable = true;

                if (isVowel(c) != isVowel(prev)) cnt = 1;
                else cnt++;

                if (cnt > 2 || (prev == c && (c != 'e' && c != 'o'))) {
                    isAcceptable = false;
                    break;
                }
                prev = c;
            }

            if (isAcceptable) {
                sb.append("<").append(str).append("> is acceptable.\n");
            } else sb.append("<").append(str).append("> is not acceptable.\n");
        }
        System.out.println(sb);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
