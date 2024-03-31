package binarysearch;

public class KokoEatingBananas {
  // 3, 6, 7, 11
  // 27
  // 8 but keep it bounded to values and has to fixed number of bananas

  public static void main(String[] args) {
    int[] array = {3, 6, 7, 11}; // 1, 2, 2, 3 -> 1 + 1 + 2 + 3
    int hours = 8;
    System.out.println(binarySearch(array, hours));
  }

  private static int binarySearch(int[] piles, int hours) {
      int left = 1;
      int right = 0;
      for (int pile : piles) {
          right = Math.max(right, pile);
      }
      return binarySearchRecursive(left, right, piles,hours);
  }

    private static int binarySearchRecursive(int left, int right, int[] piles, int hours) {
            int middle = (left + right) / 2;
            int h = 0;
            for(int pile : piles) {
                h += Math.ceil ((double) pile / middle);
            }
            if(left == right) {
                return right;
            }
            if(h <= hours) {
                return binarySearchRecursive(left, middle, piles, hours);
            } else  {
                return binarySearchRecursive(middle + 1, right, piles, hours);
            }
        }

    private static int bruteForce(int[] piles, int hours) {
    int length = piles.length;
    for (int speed = 1; speed < Math.pow(10, 9); speed++) {
      int hr = hours;
      int remaining = 0;
      int counter = 0;
      while (counter < length) {
        int pile = piles[counter];
        remaining = remaining + pile;
        while (remaining > 0 && hr > 0) {
          int bananasPerHour = remaining % speed == 0 ? speed : remaining % speed; // 1 % 8
          remaining = remaining - bananasPerHour;
          hr--;
        }
        if (hr == 0) {
          break;
        }
        counter++;
      }
      if (counter == length - 1 && remaining == 0) return speed;
    }
    return 0;
  }

  private static int bruteForce2(int[] piles, int hours) {
      int speed = 1;

      while (true) {
          // hourSpent stands for the total hour Koko spends with
          // the given eating speed.
          int hourSpent = 0;

          // Iterate over the piles and calculate hourSpent.
          // We increase the hourSpent by ceil(pile / speed)
          for (int pile : piles) {
              hourSpent += Math.ceil((double) pile / speed);
              if (hourSpent > hours) {
                  break;
              }
          }

          // Check if Koko can finish all the piles within h hours,
          // If so, return speed. Otherwise, let speed increment by
          // 1 and repeat the previous iteration.
          if (hourSpent <= hours) {
              return speed;
          } else {
              speed += 1;
          }
      }
  }
}
