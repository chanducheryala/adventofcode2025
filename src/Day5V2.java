import java.util.*;

public class Day5V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair> ranges = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) break;

            String[] range = str.split("-");
            ranges.add(new Pair(Long.parseLong(range[0]), Long.parseLong(range[1])));
        }

        ranges.sort(Comparator.comparing(Pair::getX));

        List<Pair> temp = new ArrayList<>();

        for (Pair current : ranges) {
            if (temp.isEmpty()) {
                temp.add(current);
                continue;
            }

            Pair last = temp.get(temp.size() - 1);

            if (current.getX() <= last.getY()) {
                temp.set(temp.size() - 1, new Pair(last.getX(), Math.max(last.getY(), current.getY())));
            } else {
                temp.add(current);
            }
        }

        long ans = 0L;
        for (Pair p : temp) {
            ans += p.getY() - p.getX() + 1;
        }

        System.out.println(ans);
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
