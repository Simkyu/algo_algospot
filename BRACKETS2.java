package algo_algopost;
import java.util.Scanner;
import java.util.Stack;

public class BRACKETS2 {
	public static void main(String args[]) {
		
		// algospot은 스캐너로 입력, System.out.println 으로 출력(입출력 양식)
		Scanner scan= new Scanner(System.in);
		
		int C = scan.nextInt();
		
		scan.nextLine();
		
		String s;
		String result = new String();
		
		for(int i = 0; i< C ; i++) {
			s= scan.nextLine();
			
			Stack st = new Stack();
			
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j)=='[') {
					st.push(s.charAt(j));
				} else if(s.charAt(j) == ')') {
					// isEmpty먼저 확인(맨처음 닫는 괄호가 오는 경우를 위해서 : short circuit을 하기때문에 st의 판별을 하지 않음.)
					if(!st.isEmpty() && st.lastElement().toString().equals("(")) {
						st.pop();
					} else {
						// 임의의 값을 넣어 스택의 크기가 0이 되지 않도록 하며, 반복문을 끝냄.
						st.push('x');
					 break;
					}
				} else if(s.charAt(j) == '}') {
					if(!st.isEmpty() && st.lastElement().toString().equals("{") ) {
						st.pop();
					} else {
						st.push('x');
					 break;
					}
				} else if(s.charAt(j)==']') {
					if(!st.isEmpty() && st.lastElement().toString().equals("[")) {
						st.pop();
					} else {
						st.push('x');
					 break;
					}
				}
			}
			
			if(st.isEmpty()) {
				result += "YES\n";
			} else {
				result += "NO\n";
			}
		}		
		System.out.println(result);
	}
}
