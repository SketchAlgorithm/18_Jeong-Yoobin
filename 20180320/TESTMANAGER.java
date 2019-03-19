package _190318;

import java.io.*;
import java.util.*;

public class TESTMANAGER {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int[] A = new int[N];

		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();

		long managers = N;
		for(int i = 0; i<A.length; i++) {
			A[i] -= B;
		}

		long submanagers = 0;
		for (int i = 0; i < A.length; i++) {
			while (A[i] > 0) {
				A[i] -= C;
				submanagers++;
			}
		}

		System.out.println(managers + submanagers);

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

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}
