package _190220;

import java.io.*;
import java.util.*;

public class JOSEPHUS {

   public static void main(String[] args) {
      FastScanner sc = new FastScanner();
      int testcase = sc.nextInt();

      for (int t = 0; t < testcase; t++) {
         int N = sc.nextInt();
         int K = sc.nextInt();
         ArrayList<Integer> bucketlist = new ArrayList<Integer>();

         for (int i = 0; i < N; i++)
            bucketlist.add(i+1);

         
         
         int temp = 0;   //처음 병사
         for (int i = 0; i < N - 2; i++) {
            bucketlist.remove(temp);      //자살
            temp = (temp + K - 1) % bucketlist.size(); //리스트에서 삭제해서 한칸씩 밀리므로 인덱스 1 뺴주기
         }
         
         
         //출력
         for(int i = 0; i<bucketlist.size(); i++)
            System.out.print(bucketlist.get(i) + " ");
         System.out.println();

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
