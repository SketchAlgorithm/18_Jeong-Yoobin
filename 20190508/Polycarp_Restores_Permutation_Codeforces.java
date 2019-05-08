package _190508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Polycarp_Restores_Permutation_Codeforces {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] q = new int[n-1];
		for(int i = 0; i<n-1; i++)
			q[i] = sc.nextInt();
		
		int[] p = makep(q);
		if(isPermutation_O_logn(p))
			for(int i = 0; i<p.length; i++)
				System.out.print(p[i]+" ");
		else
			System.out.println(-1);
					
	}


	
	static int[] makep(int[] q) {
		int[] p = new int[q.length+1];
		p[0] = 0;
		for(int i = 1; i<p.length; i++) 
			p[i] = p[i-1] + q[i-1];
		
		int min = p[0];
		for(int i = 1; i<p.length; i++) 
			if(min > p[i])
				min = p[i];
		
		for(int i = 0; i<p.length; i++)
			p[i] = p[i] - min + 1;
		
		return p;
		
		
	}
	
	static boolean isPermutation_O_logn(int[] arr) {
		int[] temp = arr.clone();
		Arrays.sort(temp);
		for(int i = 0; i<temp.length ;i++)
			if(temp[i] != i+1)
				return false;
		return true;
	}
	
	static boolean isPermutation_O_nsquare(int[] arr) {
		for(int i = 1; i<=arr.length; i++) {
			boolean flag = false;
			for(int j = 0; j<arr.length; j++) {
				if(arr[j] == i)
					flag = true;
			}
			if(flag)
				continue;
			else 
				return false;
		}
		return true;
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
