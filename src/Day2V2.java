import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair> ranges = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) break;

            String[] pairs = str.split(",");
            for (String pair : pairs) {
                pair = pair.trim();
                if (pair.isEmpty()) continue;

                String[] range = pair.split("-");
                ranges.add(new Pair(
                        Long.parseLong(range[0].trim()),
                        Long.parseLong(range[1].trim())
                ));
            }
        }

        Long ans = 0L;
        for(Pair p: ranges) {
            Long x = p.getX();
            Long y = p.getY();
            for(Long i = x; i <= y; i++) {
                if(isInValid(String.valueOf(i))) {
                    ans += i;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isInValid(String str) {
        int n = str.length();
        if (n == 1) return false;
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) continue;
            boolean ok = true;
            String first = str.substring(0, len);
            for (int i = len; i < n; i += len) {
                String substring = str.substring(i, i + len);
                if (!substring.equals(first)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
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
