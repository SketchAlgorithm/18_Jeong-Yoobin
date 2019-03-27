package _190327;

import java.io.*;
import java.util.*;

public class TRIANGLEPATH {

	public static void main(String[] args) {

		FastScanner sc = new FastScanner();
		int testcase = sc.nextInt();
		for(int t = 0; t<testcase ; t++) {
			int N = sc.nextInt();
			
			int[][] cache = new int[N][];		//인덱스 : 해당 숫자 위치들
			for(int i = 0; i<N; i++) {
				cache[i] = new int[N];
				
			}
			cache[0][0] = sc.nextInt();
			for(int i = 1; i<N; i++) {
				int temp = sc.nextInt();
				cache[i][0] = cache[i-1][0] + temp;
				for(int j = 1; j<i; j++) {
					temp = sc.nextInt();
					if(cache[i-1][j] < cache[i-1][j-1] )
						cache[i][j] = cache[i-1][j-1] + temp;
					else
						cache[i][j] = cache[i-1][j] + temp;
				}
				temp = sc.nextInt();
				cache[i][i] = cache[i-1][i-1] + temp;
			}
			
			int maxindex = 0;
			for(int i = 1; i<N; i++) 
				if(cache[N-1][i] > cache[N-1][maxindex])
					maxindex = i;
			System.out.println(cache[N-1][maxindex]);
				
		}
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
