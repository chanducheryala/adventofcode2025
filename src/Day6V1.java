import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day6V1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> grid = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) break;

            String[] row = Arrays.stream(str.split("\\s+"))
                    .filter(s -> !s.isEmpty()) 
                    .toArray(String[]::new);  

            grid.add(row);
        }

        int n = grid.size();
        int m = grid.getFirst().length;

        long ans = 0L;
        for(int col = 0; col < m; col++) {
            long prod = 1L;
            long sum = 0L;
            for(int row = 0; row < n - 1; row++){
                prod *= Long.parseLong(grid.get(row)[col]);
                sum += Long.parseLong(grid.get(row)[col]);
            }
            if(grid.get(n - 1)[col].equals("*")) {
                ans += prod;
            } else {
                ans += sum;
            }
        }
        System.out.println(ans);
    }
}
