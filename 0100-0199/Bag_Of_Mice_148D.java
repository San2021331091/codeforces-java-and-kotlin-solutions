import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class Bag_Of_Mice_148D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
        var reader = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int w = reader[0], b = reader[1];
        double [][][] prob = new double[w + 1][b + 1][2];
        for (int p = 0; p <=w; p++){
            for (int q = 0; q <=b ; q++){
                for (int r = 0; r<= 1 ; r++){
                    prob[p][q][r] = 0.0;
                }
            }
        }
        for (int p = 1 ; p<=w; p++){
            prob[p][0][0] = 1;
        }

        for (int p = 1; p <= w; p++){
            for (int q = 1; q<=b; q++){
                double win = 1.0 * p /(p+q);
                double noWin = 1.0 - win;
                prob[p][q][0] = win + noWin * prob[p][q - 1][1];
                double outWhite = (q>=2) ? (1.0 * p /(p + q -1)) : 1.0;
                double outBlack = 1.0 - outWhite;
                prob[p][q][1] = noWin * (outWhite * prob[p - 1][q - 1][0] + outBlack * ((q >= 2) ? prob[p][q - 2][0] : 0.0));
            }
        }

        pr.println(String.format("%.12f",prob[w][b][0]));
        br.close();
        pr.flush();
        pr.close();
    }
}
