import java.io.*;
import java.util.*;

public class Day11V2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> adj = new HashMap<>();
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            if(str.isEmpty()) {
//                break;
//            }
//            String[] s = str.split(" ");
//            String first = s[0];
//            String key = first.substring(0, first.length() - 1);
//            adj.putIfAbsent(key, new ArrayList<>());
//            for(int i = 1; i < s.length; i++) {
//                adj.get(key).add(s[i]);
//            }
//            HashMap<String, Integer> mp = new HashMap<>();
//            int idx = 0;
//
//
//            for(Map.Entry<String, List<String>> entry: adj.entrySet()) {
//                if(!mp.containsKey(entry.getKey())) {
//                    mp.put(entry.getKey(), idx++);
//                }
//
//                for(String ss : entry.getValue()) {
//                    if(!mp.containsKey(ss)) {
//                        mp.put(ss, idx++);
//                    }
//                }
//                System.out.println();
//            }
//            long[][] dp = new long[1002][1002];
//
//            for(int i = 0; i < 10002; i++) {
//                Arrays.fill(dp[i], -1L);
//            }
//        }

        // for(Map.Entry<String, List<String>> entry: adj.entrySet()) {
        //     System.out.print(entry.getKey() + " ");

        //     for(String str : entry.getValue()) {
        //          System.out.print(str + " ");
        //     }
        //      System.out.println();
        // }

//        long svr_to_fft = dfs("svr", adj, "fft", dp);
//        long fft_to_dac = dfs("fft", adj, "dac", dp);
//        long dac_to_out = dfs("dac", adj, "out", dp);
//        long svr_to_dac = dfs("svr", adj, "dac", dp);
//        long dac_to_fft = dfs("dac", adj, "fft", dp);
//        long fft_to_out = dfs("fft", adj, "out", dp);
//

//
//        long res = (svr_to_fft * fft_to_dac * dac_to_out) +  (svr_to_dac * dac_to_fft * fft_to_out);
//        System.out.println(res);
    }
}