package ratelimiter;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class SlidingWindowRateLimiter {

  public static void main(String[] args) {
    isAllowed(
        "C:\\Users\\sunee\\leetcode\\src\\input.txt", "C:\\Users\\sunee\\leetcode\\src\\output.txt");
  }

  public static void isAllowed(String inputFileName, String outputFileName) {
    int maxRequests = 5;
    int timeWindow = 1000;
    ConcurrentLinkedDeque<Long> queue =
        new ConcurrentLinkedDeque<>();
    List<String> result = new ArrayList<>();
    try (FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      int lines = Integer.parseInt(bufferedReader.readLine());
      while (lines > 0) {
        String[] values = bufferedReader.readLine().split(",");
        long timestamp = Long.parseLong(values[1]);
        while (!queue.isEmpty() && timestamp - queue.peekFirst() > timeWindow) {
          queue.pollFirst();
        }
        if (queue.size() < maxRequests) {
          queue.addLast(timestamp);
          result.add("PASSED");
        } else {
          result.add("BLOCKED");
        }
        lines--;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
      for (String value : result) {
        bufferedWriter.write(value + System.lineSeparator());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
