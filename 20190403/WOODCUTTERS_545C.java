package _20190403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WOODCUTTERS {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int result = 1;
		if(n!=1)
			result++;
		int[] coor = new int[n];
		int[] height = new int[n];
		for(int i = 0; i<n; i++) {
			coor[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		for(int i = 1; i<n-1; i++) {
			if(coor[i]-coor[i-1] > height[i])
				result++;	
			else if(coor[i+1]-coor[i] > height[i]) {
				result++;
				coor[i] += height[i];
			}
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
