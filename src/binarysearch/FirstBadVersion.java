package binarysearch;

public class FirstBadVersion {
  public static void main(String[] args) {
    int[] versions = {1, 2, 4, 5, 6};
    // System.out.println(isBadVersion(versions, version, 1, versions.length));
    System.out.println(firstBadVersion(1, 6));
    // System.out.println(isBadVersion(versions, 6, 1, versions.length));
  }

  private static int firstBadVersion(int left, int right) {
    int mid = (left + right) / 2;
    if (left == right) {
      return left;
    }
    if (isBadVersion(mid)) {
      return firstBadVersion(left, mid - 1);
    } else {
      return firstBadVersion(mid + 1, right);
    }
  }

  private static boolean isBadVersion(int version) {
    return version >= 6;
  }
}
