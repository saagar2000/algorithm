package comparator;

public class CompareVersion {

  public static void main(String[] args) {
    System.out.println(compareVersion("1.01", "1.001"));
  }

  public static int compareVersion(String version1, String version2) {

    String[] parts1 = version1.split("\\.");
    String[] parts2 = version2.split("\\.");

    int len1 = parts1.length;
    int len2 = parts2.length;

    int max = Math.max(len1, len2);

    int compare = 0;
    for (int i = 0; i < max; i++) {
      int part1 = 0;
      if (i < len1) {
        part1 = Integer.parseInt(parts1[i]);
      }
      int part2 = 0;
      if (i < len2) {
        part2 = Integer.parseInt(parts2[i]);
      }
      compare = Integer.compare(part1, part2);
      if (compare != 0) return compare;
    }
    return compare;
  }
}
