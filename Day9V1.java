import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        List<Pair> pairs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.isEmpty()) break;
            String[] pair = str.split(",");
            long x = Long.parseLong(pair[1]);
            long y = Long.parseLong(pair[0]);
            pairs.add(new Pair(x, y));
        }

        // 4777824480
        // 4777824480

        long ans = 0L;
        int n = pairs.size();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n && i != j; j++) {
                // long minX = Math.min(pairs.get(i).getX(), pairs.get(j).getX());
                // long maxX = Math.max(pairs.get(i).getX(), pairs.get(j).getX());
                
                
                // long minY = Math.min(pairs.get(i).getY(), pairs.get(j).getY());
                // long maxY = Math.max(pairs.get(i).getY(), pairs.get(j).getY());

                long curr = (Math.abs(pairs.get(i).getX() -  pairs.get(j).getX()) + 1) * (Math.abs(pairs.get(i).getY() -  pairs.get(j).getY()) + 1);
                ans = Math.max(ans, curr);
            }
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
