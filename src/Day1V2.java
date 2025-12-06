import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> steps = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) break;
            steps.add(str);
        }

        long curr = 50L;
        long ans = 0L;
        for(String step: steps) {
            long x = Long.parseLong(step.substring(1));
            boolean isOnZero = curr == 0L;
            if(step.charAt(0) == 'L') {
                curr -= x;
            } else {
                curr += x;
            }
            if(curr == 0L) {
                ++ans;
            } else {
                if(curr < 0L) {
                    if(isOnZero) {
                        ans += Math.abs(curr / 100L);
                    } else {
                        ans += Math.abs(curr / 100L) + 1L;
                    }
                } else {
                    ans += (curr / 100L);
                }
            }
            curr = (curr % 100L);
            if(curr < 0) {
                curr = 100 + curr;
            }
//            System.out.println(curr + " " + ans);
        }
        System.out.println(ans);
    }


    /*
    *         1 wrong - 2763 - too low
    *
    *         10 + (285) -> 195 -> 295 -> 2
    *         10 + (290) -> 100 -> 200 -> 300  - 3
    *         10 - (210) -> 0 -> -100 -> -200 -> 3
    *
    *         after applying x + curr -> if negative add ((x + curr) / 100) + 1
    *                                  -> if positive add (x + curr) / 100
    *
    *         0 - 5 => -5 -> (95) - 0
    *         0 -> 5 - 5 -> 0
    *
    *         9 - (210) -> -1 -> -101 -> -201 -> 3 -> (99)
    *
    *         300-201 = 99
    *
    *         then make abs(x + curr) % 100;
    *
    *        handling special condition at 0
    *
    *        10 - 10 -> 0 -> 1
    *
    * */
}
