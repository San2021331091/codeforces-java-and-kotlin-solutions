import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class Cookies_129A {
    public static void main(String ... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] count = new Integer[n];
        int sum = 0 , output = 0;
        var input = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int k = 0 ; k < n ; k++){
            count[k] = input[k];
            sum += count[k];
        }
        int sumMod = sum % 2;
        for (int k = 0; k < n ; k++){
            if (count[k] % 2 == sumMod)
                output++;
        }

        pr.println(output);
        br.close();
        pr.flush();
        pr.close();
    }

}
