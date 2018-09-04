package algo_algopost;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// 책 내의 풀이를 참고, 성공 - git에 올려야함
public class RUNNINMEDIAN {
	public static void main (String args[]) throws IOException {

		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int C =  Integer.parseInt(BR.readLine());
		String[] temp;
		PriorityQueue<Long> max; // 좌측
		PriorityQueue<Long> min; // 우측
		int A,B,N;
		long Sum;
		long tempdouble;

		for(int i = 0 ; i < C ; ++i) {
			temp = BR.readLine().split(" ");
			
			N = Integer.parseInt(temp[0]);
			A = Integer.parseInt(temp[1]);
			B = Integer.parseInt(temp[2]);
			
			
			max = new PriorityQueue(N/2 + 1, Collections.reverseOrder());
			min = new PriorityQueue(N/2);
			
			Sum = 1983;
			tempdouble = 1983;
			max.offer((long)1983);
			
				for(int j = 1 ; j < N ; j++) {
					tempdouble = (long) ((tempdouble*(long)A + (long)B) % 20090711);
					
				
					if(j % 2 == 0) {
						max.offer((long)tempdouble);
						swap(max,min);

					} else {
						min.offer((long)tempdouble);
						swap(max,min);
						
					}
				
					Sum += (long)max.peek();
					
					
				}
				Sum = Sum % 20090711;
				BW.write(Integer.toString((int)Sum));
				BW.newLine();
		}
		BW.flush();
		BW.close();
		BR.close();
		
	}
	
	// 크기에 따라 스왑
	public static void swap(PriorityQueue max, PriorityQueue min) {
		long temp1, temp2;
		if((long) max.peek() > (long)min.peek()) {
			temp1 = (long)max.poll();
			temp2 = (long)min.poll();
			
			max.offer(temp2);
			min.offer(temp1);
		}
	}
}
