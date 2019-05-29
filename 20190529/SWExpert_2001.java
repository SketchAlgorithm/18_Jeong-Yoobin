import java.util.*;
import java.io.*;

class SWExpert_2001 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int testcase = sc.nextInt();
    	for(int t = 0; t<testcase ;t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int m =sc.nextInt();
            for(int i = 0; i<n; i++)
                for(int j = 0; j<n; j++)
                    map[i][j] = sc.nextInt();
            
            int max = 0;
            for(int i = 0; i<n-m+1; i++)
                for(int j = 0; j<n-m+1; j++) {
                    int temp = 0;
                    for(int k = 0; k<m; k++)
                        for(int l = 0; l<m; l++)
                            temp += map[i+k][j+l];
                    if(max < temp)
                        max = temp;
                    
                }
                    
                    
            
            System.out.println("#"+(t+1)+" "+max);
                
                
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
		
		void close() {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
