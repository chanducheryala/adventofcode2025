import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4V1 {

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
//                    System.out.println(row + " " + col);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
