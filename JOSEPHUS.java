package algo_algopost;

import java.util.LinkedList;
import java.util.Scanner;

public class JOSEPHUS {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		int N, K;
	
		for(int i = 0; i < C; i++) {
			N = scan.nextInt();
			K = scan.nextInt();
			
			// 테스트 케이스마다 새로운 링크드 리스트이어야 한다.
			LinkedList link = new LinkedList();
			
			
			// 1~N까지 리스트에 추가
			for(int j = 1; j <= N; j++) {
				link.add(j);
			}
			
			// 처음 count를 K로 놓고, 1번 병사부터 이므로 removeFirst
			int count = K;
			link.removeFirst();
			
			// 사이즈가 2가 될 때까지 반복한다.
			while(link.size() != 2) {
				// 카운트가 사이즈보다 클 경우, 작아질 때까지 사이즈 만큼 빼준다. 
				// - 대신 % 는?
				while(count>link.size()) {
					count -= link.size();
				}
				// index를 0부터 따지기 때문에  기본적으로 -1을 해준다.
				count -=1;
				
				link.remove(count);
				count += K;
				
			}
			System.out.println(link.getFirst() + " " + link.getLast());
			
		}
		
		
	}
}
