package _190301;

import java.io.*;
import java.util.*;

public class GAMSI {

	public static void main(String[] args) {
		ArrayList<CCTV> CCTVs = new ArrayList<CCTV>();
		Workspace[][] workspace = input(CCTVs);
		System.out.println(getSafeSquares(CCTVs, workspace, Integer.MAX_VALUE));

	}

	static class Workspace {
		boolean isWall;
		boolean isSafe;
		CCTV cctv;

		public Workspace(boolean isWall, CCTV cctv) {
			this.isWall = isWall;
			isSafe = true;
			this.cctv = cctv;
		}

	}

	static class CCTV {
		int x, y;
		int type;
		int dir; // type 1 3 4 에 대해 값:0123, 2에 대해 값:01, 5에 대해 값:0

		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
			dir = 0;
		}

	}

	static Workspace[][] input(ArrayList<CCTV> CCTVs) {
		FastScanner sc = new FastScanner();
		int row = sc.nextInt();
		int col = sc.nextInt();
		Workspace[][] workspace = new Workspace[row][];
		for (int i = 0; i < workspace.length; i++) {
			workspace[i] = new Workspace[col];
			for (int j = 0; j < workspace[i].length; j++) {
				int temp = sc.nextInt();
				if (temp == 0)
					workspace[i][j] = new Workspace(false, null);
				else if (temp != 6) {
					CCTV tempObj = new CCTV(temp, i, j);
					workspace[i][j] = new Workspace(false, tempObj);
					CCTVs.add(tempObj);
				} else
					workspace[i][j] = new Workspace(true, null);
			}
		}
		return workspace;
	}

	static int getSafeSquares(ArrayList<CCTV> CCTVs, Workspace[][] workspace, int safesquares) {
		if (CCTVs.size() == 0)
			return workspaceGamsi(workspace, CCTVs);
		return getSafeSquares(CCTVs, workspace, safesquares, 0);
	}

	static int getSafeSquares(ArrayList<CCTV> CCTVs, Workspace[][] workspace, int safesquares, int depth) {

		int j_trigger = 4;
		if (CCTVs.get(depth).type == 2) // 회전이 두번만 필요
			j_trigger = 2;
		else if (CCTVs.get(depth).type == 5) // 회전 무필요
			j_trigger = 1;

		for (int j = 0; j < j_trigger; j++) {
			CCTVs.get(depth).dir = j;
			int temp_safesquares;
			if (depth == CCTVs.size() - 1) {
				temp_safesquares = workspaceGamsi(workspace, CCTVs);
				workspaceClear(workspace);
			} else {
				temp_safesquares = getSafeSquares(CCTVs, workspace, safesquares, depth + 1);
			}
			if (temp_safesquares < safesquares)
				safesquares = temp_safesquares;
		}

		return safesquares;

	}

	static void workspaceClear(Workspace[][] workspace) {
		for (int i = 0; i < workspace.length; i++) {
			for (int j = 0; j < workspace[i].length; j++)
				if (!workspace[i][j].isSafe)
					workspace[i][j].isSafe = true;
		}
	}

	static int workspaceGamsi(Workspace[][] workspace, ArrayList<CCTV> CCTVs) {
		int sum = 0;

		for (int i = 0; i < CCTVs.size(); i++) {
			switch (CCTVs.get(i).type) {
			case 1:
				makeUnsafe(CCTVs.get(i), workspace);
				break;
			case 2:
				switch (CCTVs.get(i).dir) {
				case 0:
					makeUnsafe(0, CCTVs.get(i), workspace);
					makeUnsafe(1, CCTVs.get(i), workspace);
					break;
				case 1:
					makeUnsafe(2, CCTVs.get(i), workspace);
					makeUnsafe(3, CCTVs.get(i), workspace);
					break;
				}
				break;
			case 3:
				switch (CCTVs.get(i).dir) {
				case 0:
					makeUnsafe(3, CCTVs.get(i), workspace);
					makeUnsafe(0, CCTVs.get(i), workspace);
					break;
				case 1:
					makeUnsafe(0, CCTVs.get(i), workspace);
					makeUnsafe(2, CCTVs.get(i), workspace);
					break;
				case 2:
					makeUnsafe(2, CCTVs.get(i), workspace);
					makeUnsafe(1, CCTVs.get(i), workspace);
					break;
				case 3:
					makeUnsafe(1, CCTVs.get(i), workspace);
					makeUnsafe(3, CCTVs.get(i), workspace);
					break;

				}
				break;
			case 4:
				switch (CCTVs.get(i).dir) {
				case 0:
					makeUnsafe(1, CCTVs.get(i), workspace);
					makeUnsafe(3, CCTVs.get(i), workspace);
					makeUnsafe(0, CCTVs.get(i), workspace);
					break;
				case 1:
					makeUnsafe(3, CCTVs.get(i), workspace);
					makeUnsafe(0, CCTVs.get(i), workspace);
					makeUnsafe(2, CCTVs.get(i), workspace);
					break;
				case 2:
					makeUnsafe(0, CCTVs.get(i), workspace);
					makeUnsafe(2, CCTVs.get(i), workspace);
					makeUnsafe(1, CCTVs.get(i), workspace);
					break;
				case 3:
					makeUnsafe(2, CCTVs.get(i), workspace);
					makeUnsafe(1, CCTVs.get(i), workspace);
					makeUnsafe(3, CCTVs.get(i), workspace);
					break;
				}
				break;
			case 5:
				for (int j = 0; j < 4; j++)
					makeUnsafe(j, CCTVs.get(i), workspace);
				break;
			}
		}
		for (int i = 0; i < workspace.length; i++)
			for (int j = 0; j < workspace[i].length; j++)
				if (workspace[i][j].isSafe && workspace[i][j].cctv == null && !workspace[i][j].isWall)
					sum++;
		return sum;
	}

	static void makeUnsafe(CCTV cctv, Workspace[][] workspace) {
		makeUnsafe(cctv.dir, cctv, workspace);
	}

	static void makeUnsafe(int _case, CCTV cctv, Workspace[][] workspace) {
		switch (_case) { // 6428 순(키패드)
		case 0:
			for (int j = cctv.y; j < workspace[cctv.x].length; j++) {
				if (workspace[cctv.x][j].isWall)
					break;
				workspace[cctv.x][j].isSafe = false;
			}
			break;
		case 1:
			for (int j = cctv.y; j >= 0; j--) {
				if (workspace[cctv.x][j].isWall)
					break;
				workspace[cctv.x][j].isSafe = false;
			}
			break;
		case 2:
			for (int j = cctv.x; j < workspace.length; j++) {
				if (workspace[j][cctv.y].isWall)
					break;
				workspace[j][cctv.y].isSafe = false;
			}
			break;
		case 3:
			for (int j = cctv.x; j >= 0; j--) {
				if (workspace[j][cctv.y].isWall)
					break;
				workspace[j][cctv.y].isSafe = false;
			}
			break;

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
