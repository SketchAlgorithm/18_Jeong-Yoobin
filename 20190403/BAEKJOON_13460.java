package _20190403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_13460 {

	static int rx;
	static int ry;
	static int bx;
	static int by;
	
	public static void main(String[] args) {

		FastScanner sc = new FastScanner();
		int row = sc.nextInt();
		int col = sc.nextInt();
		char[][] plate = new char[row][];
		for (int i = 0; i < row; i++) {
			plate[i] = new char[col];
			for (int j = 0; j < col; j++) {
				plate[i][j] = sc.nextChar();
				if(plate[i][j]=='R') {
					rx = i;
					ry = j;
				}
				else if(plate[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

	}
	
	static int move(int dir, char[][] plate, int depth) {
		while(!isStopped(dir, plate)) {
			char temp;
			switch(dir) {
			case 8:
				if(plate[rx-1][ry] =='.') {
					temp = plate[rx-1]
				}
			case 2:
			case 4:
			case 6:
				
			}
		}
		return depth;
	}
	
	
	
	
	
	static boolean isStopped(int dir, char[][] plate) {
		switch(dir) {
		case 8:
			return plate[rx-1][ry]!='.'&&plate[bx-1][by]!='.';
		case 2:	
			return plate[rx+1][ry]!='.'&&plate[bx+1][by]!='.';
		case 4:
			return plate[rx][ry-1]!='.'&&plate[bx][by-1]!='.';
		case 6:
			return plate[rx][ry+1]!='.'&&plate[bx][by+1]!='.';
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
