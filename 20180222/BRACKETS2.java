package _190220;

import java.util.*;
import java.io.*;

public class BRAKETS2 {

   public static void main(String[] args) {
      FastScanner sc = new FastScanner();

      int testcase = sc.nextInt();
      for (int t = 0; t < testcase; t++) {
         String input = sc.next();
         Stack<Integer> brackets = new Stack<Integer>();
         // FILO 구조, 스택을 사용
         // 0 비어있음 1 ( -1 ) 2 { -2 } 3 [ -3 ]

         boolean flag = true;
         for (char a : input.toCharArray()) {
            int temp = 0;
            switch (a) {
            case '(':
               temp = 1;
               break;
            case ')':
               temp = -1;
               break;
            case '{':
               temp = 2;
               break;
            case '}':
               temp = -2;
               break;
            case '[':
               temp = 3;
               break;
            case ']':
               temp = -3;
               break;
            }
            if (temp < 0 && (brackets.isEmpty() || brackets.peek() + temp != 0)) {   //현재 괄호가 닫히는 괄호이며, 열린 괄호가 없거나 현재와 다를때
               flag = false;
               break;
            } 
            else if(temp < 0) {   //괄호가 제대로 닫힌 것
               brackets.pop();
               continue;
            }
            brackets.push(temp);                  //새 괄호가 열린 것

         }
         
         if (flag && brackets.isEmpty())
            System.out.println("YES");
         else
            System.out.println("NO");
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
            String str;
            try {
               str = in.readLine();
               if (str == null)
                  return null;
               st = new StringTokenizer(str);
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
