import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Median_166C {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
        var line = Stream.of(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long n = line[0], x = line[1];
        long temp, left = 0L, equal = 0L , right = 0L;
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int k = 0 ; k < n ; k++){
            temp = Long.parseLong(str.nextToken());
            if(temp < x){
                ++left;
            }
            else if(temp == x){
                ++equal;
            }
            else if(temp > x){
                ++right;
            }
        }
        long output = 0L;
        if (equal == 0){
            output = 1L;
            equal = 1L;
        }
        if(left + equal < right){
            output += right - left - equal;
            if((n + output)%2 == 1){--output;}
        }
        else if(left + 1 > right + equal - 1){
            output += left + 2 - right - equal;
            if((n + output)%2 == 0){--output;}
        }
        pr.println(output);
        br.close();
        pr.flush();
        pr.close();
    }
}
