package _190220;

import java.io.*;
import java.util.*;

public class MICROORGANISM_ISOLATION {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int testcase = sc.nextInt();

		for (int t = 0; t < testcase; t++) {

			int N = sc.nextInt(); // 정사각형
			int M = sc.nextInt(); // 시간
			int K = sc.nextInt(); // 최초 배치 군집 수

			Glosbe[][] plate = new Glosbe[N + 2][];
			for (int i = 0; i < plate.length; i++)
				plate[i] = new Glosbe[N + 2];

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int num = sc.nextInt();
				int direction = sc.nextInt();
				plate[x][y] = new Glosbe(x, y, num, direction);
			}
			for (int i = 0; i < M; i++)
				timelapse(plate);

			int sum = 0;
			for (int i = 0; i < plate.length; i++) {
				for (int j = 0; j < plate[i].length; j++) {
					if (plate[i][j] != null)
						sum += plate[i][j].num;
				}
			}
			System.out.println("#" + (t + 1) + " " + sum);
		}
	}

	static void timelapse(Glosbe[][] plate) {
		for (int i = 0; i < plate.length; i++) {
			for (int j = 0; j < plate[i].length; j++) {
				if (plate[i][j] != null) {
					switch (plate[i][j].direction) {
					case 1:
						plate[i][j].x--;
						break;
					case 2:
						plate[i][j].x++;
						break;
					case 3:
						plate[i][j].y--;
						break;
					case 4:
						plate[i][j].y++;
						break;
					}
					swap(plate, plate[i][j], plate[plate[i][j].x][plate[i][j].y]);
					if (plate[i][j].x == 0 || plate[i][j].x == plate.length - 1) {
						plate[i][j].direction = plate[i][j].direction % 2 + 1;
						plate[i][j].num /= 2;
					}
					if (plate[i][j].y == 0 || plate[i][j].y == plate.length - 1) {
						plate[i][j].direction = plate[i][j].direction % 2 + 3;
						plate[i][j].num /= 2;
					}
				}
			}
		}
	}

	static void swap(Glosbe[][] plate, Glosbe org, Glosbe dir) {
		if (dir == null) {
			plate[dir.x][dir.y] = org;
			plate[org.x][org.y] = null;
		} else {
			Glosbe temp = dir;
			plate[dir.x][dir.y] = org;
			plate[temp.x][temp.y] = dir;
		}

	}

	static class Glosbe { // 군집 객체
		int x;
		int y;
		int num;
		int direction; // 상하좌우 1234

		public Glosbe(int x, int y, int num, int direction) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.direction = direction;
		}

		static void unify(ArrayList<Glosbe> list) {

		}

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
	}

}
