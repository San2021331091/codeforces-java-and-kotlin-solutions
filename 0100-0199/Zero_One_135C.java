import java.io.*;

public class Zero_One_135C {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
       String s = br.readLine().trim();
       long zeros = 0L,ones = 0L, qs = 0L;
       for (char p : s.toCharArray()){
          switch (p){
              case '0' -> ++zeros;
              case '1' -> ++ones;
              case '?' -> ++qs;
          }
       }
       char last = s.charAt(s.length() - 1);
       long minDiff = ones - (zeros + qs);
       long maxDiff = (ones + qs) - zeros;
       if (minDiff < 0) pr.println("00");
       if((last == '1' && minDiff <= 1 && 0 <= maxDiff) || (last == '?' && minDiff <= -1 && 0 <= maxDiff)){pr.println("01");}
       if((last == '0' && minDiff <= 1 && 0 <= maxDiff) || (last == '?' && minDiff <= 1 && 2 <= maxDiff)){pr.println("10");}
       if(maxDiff > 1){pr.println("11");}
       pr.println();
       br.close();
       pr.flush();
       pr.close();
   }
}
