import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4V2 {

    private static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> grid = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if(line.isEmpty()) break;
            grid.add(line.toCharArray());
        }

        int ans = 0;
        while (true) {
            List<Pair> pairs = new ArrayList<>();
            int canBeRemoved = solve(grid, pairs);
            if(canBeRemoved > 0) {
                ans += canBeRemoved;
                remove(grid, pairs);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    private static int solve(List<char[]> grid,  List<Pair> pairs) {
        int n = grid.size();
        int m = grid.getFirst().length;

        int[] dirX = {-1,  1,  0,  0, -1, -1,  1,  1};
        int[] dirY = { 0,  0, -1,  1, -1,  1, -1,  1};

        int ans = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid.get(row)[col] != '@') continue;
                int papers = 0;
                for(int d = 0; d < 8; d++) {
                    int newRow = row + dirX[d];
                    int newCol = col + dirY[d];
                    if(isValid(newRow, newCol, n, m) && grid.get(newRow)[newCol] == '@') {
                        papers++;
                    }
                }

                if(papers < 4) {
                    pairs.add(new Pair((long) row, (long) col));
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void remove(List<char[]> grid, List<Pair> pairs) {
        for(Pair p: pairs) {
            grid.get(Math.toIntExact(p.getX()))[Math.toIntExact(p.getY())] = '.';
        }
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
