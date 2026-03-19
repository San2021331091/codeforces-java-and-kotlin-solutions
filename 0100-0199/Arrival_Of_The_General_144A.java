import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Arrival_Of_The_General_144A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numSoldiers = Integer.parseInt(br.readLine().trim());
        int currentSoldier,minSoldier = 101,maxSoldier = 0,minPos = 100,maxPos = 0;
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int k = 0; k<numSoldiers; k++){
            currentSoldier = Integer.parseInt(st.nextToken());
            if(currentSoldier >  maxSoldier){maxPos = k; maxSoldier = currentSoldier;}
            if(currentSoldier <= minSoldier){minPos = k; minSoldier = currentSoldier;}
        }
        int output = maxPos + (numSoldiers -1 - minPos);
        if (minPos < maxPos) --output;
        bw.write(output+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
