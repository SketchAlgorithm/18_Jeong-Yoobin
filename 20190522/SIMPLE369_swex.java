package _190522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SIMPLE369 {

	public static void main(String[] args) {
		FastScanner sc= new FastScanner();
		int N = sc.nextInt();
		for(int i = 1; i<=N; i++) {
			String temp = String.valueOf(i);
			boolean isClapped = false;
			for(int j = 0; j<temp.length();j++)
				if((temp.charAt(j) - '0') != 0 && (temp.charAt(j) - '0')%3 == 0) {
					isClapped = true;
					System.out.print("-");
				}
			if(isClapped)
				System.out.print(" ");
			else
				System.out.print(i+" ");
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
