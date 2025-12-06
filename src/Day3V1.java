import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3V1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair> ranges = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) break;

            String[] range = str.split("-");
            ranges.add(new Pair(Long.parseLong(range[0]), Long.parseLong(range[1])));
        }

        int ans = 0;
        for(Pair p: ranges) {
            Long x = p.getX();
            Long y = p.getY();
            for(Long i = x; i <= y; i++) {
                if(isInValid(String.valueOf(i))) {
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isInValid(String str) {
        int n = str.length();
        if(n % 2 == 1) return false;
        String one = str.substring(0, n / 2);
        String two = str.substring(n / 2);
        return one.equals(two);
    }

    public static class Pair {
        private final Long x;
        private final Long y;

        public Pair(Long x, Long y) {
            this.x = x;
            this.y = y;
        }

        public Long getX() { return x; }
        public Long getY() { return y; }

        @Override
        public String toString() {
            return x + "-" + y;
        }
    }
}
