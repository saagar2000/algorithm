import java.io.*;
import java.util.*;
import java.util.stream.*;

public class PotentialOfWinner {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] values = br.readLine().split(" ");
    int n = Integer.parseInt(values[0]); // Reading input from STDIN
    long k = Long.parseLong(values[1]);
    int[] ptl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
    Deque<Integer> deque =
        Arrays.stream(ptl).boxed().collect(Collectors.toCollection(ArrayDeque::new));
    Integer first = deque.pop();
    int count = 0;
    while (k != count) {
      Integer second = deque.pop();
      if (first > second) {
        count++;
      } else {
        count = 1;
        first = second;
      }
      deque.addLast(second);
    }
    System.out.println(first);
  }
}
