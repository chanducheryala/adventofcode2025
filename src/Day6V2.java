import java.util.*;

public class Day6V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> grid = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.isEmpty()) break;
            grid.add(str.toCharArray());
        }

        for(char[] chars: grid) {
            System.out.println(Arrays.toString(chars));
        }

        int n = grid.size();
        int m = grid.getFirst().length;

        long sum = 0L;
        long prod = 1L;
        long ans = 0L;
        for(int col = m - 1; col >= 0; col--) {
            StringBuilder sb = new StringBuilder();
            for(int row = 0; row < n - 1; row++) {
                char c = grid.get(row)[col];
                if(c != ' ') {
                    sb.append(c);
                }
            }
            if(!sb.isEmpty()) {
//                System.out.println(col + " " + sb.toString());
                prod *= Long.parseLong(sb.toString());
                sum += Long.parseLong(sb.toString());
            }

            if(grid.get(n - 1)[col] == '*') {
                ans += prod;
                prod = 1L;
                sum = 0L;
            } else if(grid.get(n - 1)[col] == '+') {
                ans += sum;
                prod = 1L;
                sum = 0L;
            }
        }

        System.out.println(ans);
    }
}
