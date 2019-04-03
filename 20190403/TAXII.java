package _20190403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TAXI_158B {

	public static void main(String[] args) {

		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] arr = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < n; i++)
			arr[sc.nextInt()]++;
		int result = arr[4];
		result += arr[3];
		arr[1] -= arr[3];
		result += arr[2] / 2;

		if (arr[2] % 2 == 1) {
			arr[1] -= 2;
			result++;
		}

		if (arr[1] > 0) {
			result += arr[1] / 4;
			if (arr[1] % 4 != 0)
				result++;
		}

		System.out.println(result);

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
