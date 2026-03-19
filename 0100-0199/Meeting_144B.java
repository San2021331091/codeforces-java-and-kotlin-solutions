import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Stream;

public class Meeting_144B {
 public static boolean isClose(long x1, long y1,long x2,long y2, long r){
     return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) <= r * r);
 }
 public static record Pair<T extends Comparable<T>,F extends Comparable<F>>(T first,F second) implements Comparable<Pair<T, F>> {

     @Override
     public int compareTo(Pair<T, F> other) {
         int cmp = this.first.compareTo(other.first);
         return (cmp!= 0) ? cmp : this.second.compareTo(other.second);
     }
 }
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var input = Stream.of(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
         SortedSet<Pair<Long, Long>> coldGenerals = getPairs(input);
         List<Pair<Long,Long>> radiators = new ArrayList<>();
         List<Long> radii = new LinkedList<>();
         var numRadiators = Long.parseLong(br.readLine().trim());
         for (long k = 0L ; k < numRadiators ; k++){
             var tokenizer = new StringTokenizer(br.readLine().trim());
             long xTemp = Long.parseLong(tokenizer.nextToken());
             long yTemp = Long.parseLong(tokenizer.nextToken());
             long tempRadius = Long.parseLong(tokenizer.nextToken());
             radiators.add(new Pair<>(xTemp,yTemp));
             radii.add(tempRadius);
         }

         for (int k = 0; k<numRadiators ; k++){
             Iterator<Pair<Long,Long>> itr = coldGenerals.iterator();
             while (itr.hasNext()){
                 var next = itr.next();
                 if (isClose(next.first(),next.second(),radiators.get(k).first(),radiators.get(k).second(),radii.get(k))) itr.remove();
             }
         }
         bw.write(coldGenerals.size()+"\n");
         br.close();
         bw.flush();
         bw.close();
}

    private static SortedSet<Pair<Long, Long>> getPairs(long[] input) {
        long xa = input[0],ya= input[1],xb= input[2],yb= input[3];
        long xMin,xMax,yMin,yMax;
        boolean sw = (xa<xb);
        if (sw) {
            xMin = xa;
            xMax = xb;
        } else {
            xMin = xb;
            xMax = xa;
        }

        sw = (ya<yb);
        if (sw){
            yMin = ya;
            yMax = yb;
        }
        else {
            yMin = yb;
            yMax = ya;
        }

        SortedSet<Pair<Long,Long>> coldGenerals = new TreeSet<>();

        for(long k = yMin; k <= yMax; k++){coldGenerals.add(new Pair<>(xMin,k));}
        for(long k = yMin; k <= yMax; k++){coldGenerals.add(new Pair<>(xMax,k));}
        for(long k = xMin; k <= xMax; k++){coldGenerals.add(new Pair<>(k,yMin));}
        for(long k = xMin; k <= xMax; k++){coldGenerals.add(new Pair<>(k,yMax));}
        return coldGenerals;
    }

}
