import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Suspects_156B {
    protected enum SuspectedValue{
        Truth,Lie,Not_Defined
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var line = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long n = line[0], m = line[1];
        long[] a = new long[(int)n];
        long[] c = new long[(int)n];
        Arrays.fill(a,0L);
        Arrays.fill(c,0L);
        boolean[] pos = new boolean[(int)n];
        Arrays.fill(pos,true);
        long neg = 0L;
        for (int p = 0; p<n; p++){
            var tokenizer = new StringTokenizer(br.readLine().trim());
            a[p] = Long.parseLong(tokenizer.nextToken());
            if(a[p] > 0){--a[p]; ++c[(int)a[p]];}
            else{a[p] = -a[p]; --a[p]; --c[(int)a[p]]; ++neg; pos[p] = false;}
        }
        long num = 0L;
        for (int p = 0; p<n ; p++){
            num += (c[p] == m - neg) ? 1L : 0L;
        }
        for (int p = 0; p < n ; p++){
            if (c[(int)a[p]] != m - neg) bw.write(pos[p] ? SuspectedValue.Lie.name()+"\n" : SuspectedValue.Truth.name()+"\n");
            else if(num == 1L) bw.write(pos[p] ? SuspectedValue.Truth.name()+"\n" : SuspectedValue.Lie.name()+"\n");
            else {
                var result = SuspectedValue.Not_Defined.name().replace("_", " ").toLowerCase();
                var modifiedResult = result.substring(0,1).toUpperCase() + result.substring(1);
                bw.write(modifiedResult + "\n");
            }}
        br.close();
        bw.flush();
        bw.close();
    }
}
