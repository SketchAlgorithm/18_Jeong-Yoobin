package _190301;

import java.io.*;
import java.util.*;

public class EQUIVALENT_STRINGS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FastScanner sc = new FastScanner();
		if (equivalent(sc.next(), sc.next()))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static boolean equivalent(String a, String b) {
		if (a.equals(b)) 
			return true;
		else if (a.length() % 2 == 1 && b.length() % 2 == 1)
			return false;

		String a1 = a.substring(0, a.length() / 2);
		String a2 = a.substring(a.length() / 2);
		String b1 = b.substring(0, b.length() / 2);
		String b2 = b.substring(b.length() / 2);

		if ((equivalent(a1, b1) && equivalent(a2, b2)) || (equivalent(a1, b2) && equivalent(a2, b1)))
			return true;
		else
			return false;

	}

	static class FastScanner {
		BufferedReader in;
		StringTokenizer st;

		public FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
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

	}

}
