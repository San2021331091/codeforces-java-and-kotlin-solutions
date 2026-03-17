import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Stream;

public class Students_And_Shoelaces_129B {
    protected record Pair<T extends Comparable<T>, F extends Comparable<F>>(T first, F second)
            implements Comparable<Pair<T, F>> {
        @Override
        public int compareTo(Pair<T, F> o) {
            int cmp = this.first.compareTo(o.first);
            if (cmp != 0) return cmp;
            return this.second.compareTo(o.second);
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
        var input = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];
        int[] degree = new int[n + 1];
        Arrays.fill(degree, 0);
        SortedSet<Pair<Integer,Integer>> edges = new TreeSet<>();
        for (int k = 0; k<m ; k++){
            var line = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int left = line[0], right = line[1];
            edges.add(new Pair<>(left,right));
            ++degree[left];
            ++degree[right];
        }
        int numGroups = 0;
        while (!edges.isEmpty()){
            List<Integer> toDecrease = new LinkedList<>();
            for (int k = 0 ; k <=n ; k++){
                if (degree[k] == 1){
                    toDecrease.add(k);
                  Iterator<Pair<Integer,Integer>> iterator = edges.iterator();

                  while (iterator.hasNext()){
                      Pair<Integer,Integer> edge = iterator.next();
                      if (edge.first == k){
                          toDecrease.add(edge.second);
                          iterator.remove();
                          break;
                      }
                      else if (edge.second == k){
                          toDecrease.add(edge.first);
                          iterator.remove();
                          break;
                      }
                  }
                }
            }
            if (toDecrease.isEmpty()) break;
            else {
               toDecrease.forEach((k) -> --degree[k]);
                ++numGroups;
            }
        }

        pr.println(numGroups);
        br.close();
        pr.flush();
        pr.close();

    }

}
