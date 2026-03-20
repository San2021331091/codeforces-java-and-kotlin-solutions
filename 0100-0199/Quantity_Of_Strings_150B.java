import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Quantity_Of_Strings_150B {
    private static final long M = 1000000007;
    public static void main(String ... args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var lines = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long n = lines[0],m = lines[1], k = lines[2];
        var output = getOutput(k, n, m);
        bw.write((int)output+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
    private static long getOutput(long k, long n, long m) {
        var output = 1L;
        var res = (k == 1 || k > n)? 1 :(k == n) ? 2 : (k %2==1)? 3 :(k % 2 == 0)? 4 : -1;
        switch (res){
            case 1 ->{
                for (int p = 0; p< n; p++){
                    output = (output * m) % M;
                }
            }
            case 2 ->{
                for (int p = 0; p<(n +1)/2 ; p++){
                    output = (output * m) % M;
                }
            }
            case 3 ->{
                output = (m * m) % M;
            }
            case 4 ->{
                output = m;
            }
        }
        return output;
    }
}
