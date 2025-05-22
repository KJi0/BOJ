package 단기간_성장;

/*
 * BOJ 1655 : 가운데를 말해요
 * 문제에서 '중간값 빠르게 찾기'를 요구 => Heap
 * 균형 유지하며 중간값 추적하기 위해 작은 수와 큰 수로 그룹 나누기
 * => 우선순위 큐 2개(최대 힙, 최소 힙)으로 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (minHeap.size() == maxHeap.size()) maxHeap.offer(num);
			else minHeap.offer(num);
			
			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			}
			
			sb.append(maxHeap.peek() + "\n");
		}
		
		System.out.println(sb);
	}
}