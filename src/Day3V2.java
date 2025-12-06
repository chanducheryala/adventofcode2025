import java.io.*;
import java.util.*;

public class Day3V2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> banks = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.isEmpty()) break;
            banks.add(str);
        }

        long ans = 0;

        // if x <= peek then add x
        // if x > peek
        // can remove atmost n - i elements from stack

        for (String str : banks) {
            Stack<Integer> stk = new Stack<>();
            int n = str.length();

            for (int i = 0; i < n; i++) {
                int x = str.charAt(i) - '0';

                if (stk.isEmpty()) {
                    stk.push(x);
                } else {
                    while (!stk.isEmpty() && stk.size() + (n - i) > 12) {
                        if (stk.peek() < x) {
                            stk.pop();
                        } else {
                            break;
                        }
                    }
                    if (stk.size() < 12) {
                        stk.push(x);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!stk.isEmpty()) {
                sb.append(stk.pop());
            }

            sb.reverse();

            long yy = 0L;
            for (int j = 0; j < sb.length(); j++) {
                yy = yy * 10L + Long.parseLong(sb.charAt(j) + "");
            }

            ans += yy;
        }

        System.out.println(ans);
    }
}
