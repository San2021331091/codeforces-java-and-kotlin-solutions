import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Literature_Lesson_138A {
    protected static final int N = 4;
    public static void main(String ... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
        var input = Stream.of(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long n = input[0], k = input[1];
        String output = "aaaa";
        for (int p = 0; p < n ; p++){
            final String[] scheme = new String[N];
            Arrays.fill(scheme,"");
            for (int q = 0 ; q < N ; q++){
                String line = br.readLine().trim();
                int count = 0;
                for (int r = line.length() - 1; r>= 0 ; r--){
                    var ln = line.toCharArray();
                    scheme[q] += ln[r];
                    if(ln[r] == 'a' || ln[r] == 'e' || ln[r] == 'i' || ln[r] == 'o' || ln[r] == 'u'){++count;}
                    if(count >= k){break;}
                }
            }

            if(scheme[0].length() < k || scheme[1].length() < k || scheme[2].length() < k || scheme[3].length() < k){output = "NO"; break;}
            else if(scheme[0].equals(scheme[1]) && scheme[1].equals(scheme[2]) && scheme[2].equals(scheme[3])){ continue; }
            else if(scheme[0].equals(scheme[1]) && scheme[2].equals(scheme[3]) && (output.equals("aaaa") || output.equals("aabb"))){output = "aabb";}
            else if(scheme[0].equals(scheme[2]) && scheme[1].equals(scheme[3]) && (output.equals("aaaa") || output.equals("abab"))){output = "abab";}
            else if(scheme[0].equals(scheme[3]) && scheme[1].equals(scheme[2]) && (output.equals("aaaa") || output.equals("abba"))){output = "abba";}
            else{output = "NO"; break;}

        }

        pr.println(output);
        br.close();
        pr.flush();
        pr.close();

    }
}
