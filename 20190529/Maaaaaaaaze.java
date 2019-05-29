package _190529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BACKJOON_16985_Maaaaaaaaaze {

	static int[][][][] cube = new int[5][4][5][5]; // 순서대로 위아래 배치(5!), 3차원, 회전, 2차원, 1차원
	static int[][][][][] cache = new int[120][5][4][5][5];
	static int[][][][][] visited = new int[120][5][4][5][5];

	public static void main(String[] args) {

		init();

		for (int i = 0; i < 120; i++)
			for (int j = 0; j < 4; j++)
				func(i, 0, j, 0, 0, 0);

		int[] temp = new int[480];
		for (int i = 0; i < 120; i++)
			for (int j = 0; j < 4; j++)
				if (cache[i][4][j][4][4] == -1)
					temp[i * 4 + j] = Integer.MAX_VALUE;
				else
					temp[i * 4 + j] = cache[i][4][j][4][4];

		int minindex = 0;
		for (int i = 1; i < 480; i++)
			if (temp[minindex] > temp[i])
				minindex = i;

		if (temp[minindex] == Integer.MAX_VALUE)
			System.out.print(-1);
		else
			System.out.print(temp[minindex] - 1);

	}

	static void init() {
		FastScanner sc = new FastScanner();
		for (int p = 0; p < 120; p++)
			for (int i = 0; i < 5; i++)
				for (int r = 0; r < 4; r++)
					for (int j = 0; j < 5; j++)
						for (int k = 0; k < 5; k++) {
							cache[p][i][r][j][k] = -1;
							visited[p][i][r][j][k] = 0;
						}
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 5; k++)
					cube[i][0][j][k] = sc.nextInt();

		for (int i = 0; i < 5; i++)
			for (int r = 1; r < 4; r++)
				for (int j = 0; j < 5; j++)
					for (int k = 0; k < 5; k++)
						cube[i][r][j][k] = cube[i][0][(int) Math.cos(Math.PI / 2 * r) * (j - 2)
								- (int) Math.sin(Math.PI / 2 * r) * (k - 2)
								+ 2][(int) Math.sin(Math.PI / 2 * r) * (j - 2)
										+ (int) Math.cos(Math.PI / 2 * r) * (k - 2) + 2];

	}



	static int[][][][] getpermutationarr(int[][][][] org, int p) {
		int[][][][] temparr = new int[5][][][];
		int a,b,c,d,e;
		a = p/24;
		b = p%24/6;
		while(a==b)
			b = (b+1)%5;
		c = p%6/2;
		while(c==a || c==b)
			c = (c+1)%5;
		d=0;
		while(d==a || d==b || d==c)
			d = (d+1)%5;
		e=0;
		while(e==a || e==b || e==c || e==d)
			e = (e+1)%5;
		
		if(p%2 == 1) {
			int swap = d;
			d = e;
			e = swap;
		}
			temparr[0] = org[a];
			temparr[1] = org[b];
			temparr[2] = org[c];
			temparr[3] = org[d];
			temparr[4] = org[e];
			
		
		return temparr;
	}



	static void func(int perm, int x, int r, int y, int z, int prev) {
		
		int[][][][] tempcube = getpermutationarr(cube, perm);
		
		visited[perm][x][r][y][z] = 1;
		if (tempcube[x][r][y][z] == 0
				|| (cache[perm][x][r][y][z] != -1 && cache[perm][x][r][y][z] <= tempcube[x][r][y][z] + prev)) {
			visited[perm][x][r][y][z] = 0;
			return;
		}

		cache[perm][x][r][y][z] = tempcube[x][r][y][z] + prev;
		if (x == 4 && y == 4 && z == 4) {
			visited[perm][x][r][y][z] = 0;
			return;
		}
		for (int i = 0; i < 4; i++)
			if (x < 4 && visited[perm][x + 1][(r + i) % 4][y][z] == 0)
				func(perm, x + 1, (r + i) % 4, y, z, cache[perm][x][r][y][z]);

		if (x > 0 && visited[perm][x - 1][r][y][z] == 0)
			func(perm, x - 1, r, y, z, cache[perm][x][r][y][z]);
		if (y < 4 && visited[perm][x][r][y + 1][z] == 0)
			func(perm, x, r, y + 1, z, cache[perm][x][r][y][z]);
		if (y > 0 && visited[perm][x][r][y - 1][z] == 0)
			func(perm, x, r, y - 1, z, cache[perm][x][r][y][z]);
		if (z < 4 && visited[perm][x][r][y][z + 1] == 0)
			func(perm, x, r, y, z + 1, cache[perm][x][r][y][z]);
		if (z > 0 && visited[perm][x][r][y][z - 1] == 0)
			func(perm, x, r, y, z - 1, cache[perm][x][r][y][z]);

		visited[perm][x][r][y][z] = 0;

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
