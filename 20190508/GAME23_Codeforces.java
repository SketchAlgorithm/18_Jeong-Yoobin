package _190508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GAME23_Codeforces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner sc = new FastScanner();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(rec(a,b,0));
		
	}
	
	static int rec(int a, int b, int count) {
		if(a == b)
			return count;
		else if(a>b)
			return -1;
		int temp1 = rec(a*2, b, count+1);
		int temp2 = rec(a*3, b, count+1);
		if(temp1!= -1)
			return temp1;
		if(temp2!= -1)
			return temp2;
		return -1;
		
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
