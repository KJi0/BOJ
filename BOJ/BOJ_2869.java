package BOJ;

/*
BOJ 2869: 달팽이는 올라가고 싶다
시간 초과가 떠서 검색해 보니
'정상에 도달하면 미끄러지지 않는다'는 조건이 있어
최종 목적지를 V가 아닌 (V - B)로 생각해야 했다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) day++;

        System.out.println(day);
    }
}
