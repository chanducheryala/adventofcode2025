import java.util.*;

public class Day7V1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> grid = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.trim().isEmpty())
                break;
            grid.add(str.toCharArray());
        }
        int n = grid.size();
        int m = grid.getFirst().length;

        int pos = -1;
        for(int i = 0; i < m; i++) {
            if(grid.get(0)[i] == 'S') {
               pos = i;
            }
        }

        assert pos != -1;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, pos));

        long ans = 0L;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            int nextRow = p.getX() + 1;
            int col = p.getY();
            if(nextRow < n) {
                if(grid.get(nextRow)[col] == '^') {
                    // split
                    boolean splitted = false;
                    if(col - 1 >= 0 && grid.get(nextRow)[col - 1] == '.') {
                        splitted = true;
                        grid.get(nextRow)[col - 1] = '|';
                        q.add(new Pair(nextRow, col - 1));
                    }

                    if(col + 1 < m && grid.get(nextRow)[col + 1] == '.') {
                        splitted = true;
                        grid.get(nextRow)[col + 1] = '|';
                        q.add(new Pair(nextRow, col + 1));
                    }
                    if(splitted) {
                        ++ans;
                    }

                } else if(grid.get(nextRow)[col] == '.') {
                    q.add(new Pair(nextRow, col));
                    grid.get(nextRow)[col] = '|';
                }
            }
        }

//        for(char[] chars: grid) {
//            System.out.println(Arrays.toString(chars));
//        }
        System.out.println(ans);
    }

    public static class Pair {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }

        @Override
        public String toString() {
            return x + "-" + y;
        }
    }
}
