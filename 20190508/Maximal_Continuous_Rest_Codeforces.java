package _190508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maximal_Continuous_Rest_Codeforces {

	public static void main(String[] args) {		
		FastScanner sc  = new FastScanner();
		int n = sc.nextInt();
		Node temphead = new Node(0);
		Node p = temphead;
		for(int i = 0; i<n; i++) {			//순환 링크드리스트 만들기
			int temp = sc.nextInt();
			p.next = new Node(temp);
			p = p.next;
		}
		p.next = temphead.next;
		for(int i = 0; i<n;i++) {
			if(p.rest == 0)
				break;
			p = p.next;
		}
		
		int maxrest = 0;
		ArrayList<Integer> continous_rests = new ArrayList<Integer>();
		for(int i=0; i<n+1; i++) {
			if(p.rest == 1)
				maxrest++;
			else {
				continous_rests.add(maxrest);
				maxrest = 0;
			}
			p = p.next;
		}
		continous_rests.add(maxrest);
		
		int max = 0;
		for(int i = 0; i<continous_rests.size(); i++)
			if(max < continous_rests.get(i))
				max = continous_rests.get(i);
		
		System.out.println(max);
		
	}

	static class Node {
		public Node next;
		public int rest;

		public Node(int rest) {
			next = null;
			this.rest = rest;
		}
	}

	static class FastScanner {
		BufferedReader in;
		StringTokenizer st;
		String temp;

		public FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
			temp = "";
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String temp = in.readLine();
					if (temp == null)
						return null;
					st = new StringTokenizer(temp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public char nextChar() {
			if (temp.equals("")) {
				temp = next();
			}
			char _temp = temp.charAt(0);
			temp = temp.substring(1);
			return _temp;

		}
	}

}
