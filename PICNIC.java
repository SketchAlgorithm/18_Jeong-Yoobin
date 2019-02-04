package _190215;

import java.io.*;
import java.util.*;

public class PICNIC {
	
	
	static int[][] EDGE;
	static int[] VISIT;
	
	public static void main(String args[]) {
		FastScanner sc = new FastScanner();
		int loop = sc.nextInt();
		for(int l = 0; l<loop; l++) {
			init(sc);
			System.out.println(analyze(VISIT.clone(), 0));
		}
		
	}
	
	
	static void init(FastScanner sc) {
		int students = sc.nextInt();
		int friends = sc.nextInt();
		EDGE = new int[students][];
		VISIT = new int[students];
		for(int i = 0; i<students; i++) {
			EDGE[i] = new int[students];
			VISIT[i] = 0;
			for(int j = 0; j<students; j++)
				EDGE[i][j] = 0;
		}
		
		for(int i = 0; i<friends; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			EDGE[a][b] = EDGE[b][a] = 1;
		}
	}

	
	static int analyze(int[] visit, int prev) {
		if(prev == -1)
			return 1;
		int sum = 0;
		visit[prev] = 1;
		for(int i = 0; i<EDGE.length; i++)
			if(EDGE[prev][i] == 1 && visit[i] == 0) {
				int[] _visit = visit.clone();
				_visit[i] = 1;
				int next = -1;
				for(int j = 0; j<_visit.length; j++)
					if(_visit[j] == 0) {
						next = j;
						break;
					}
				sum += analyze(_visit, next);
			}
		return sum;
		
			
	}
	
	static class FastScanner {
		BufferedReader in;
		StringTokenizer st;
		
		public FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String str = in.readLine();
					if (str == null) {
						return null;
					}
					st = new StringTokenizer(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		void close() {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
