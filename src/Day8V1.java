import java.util.*;

public class Day8V1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodes = new ArrayList<>();
        int id = 0;

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.trim().isEmpty()) break;
            String[] s = str.split(",");
            nodes.add(new Node(id++, Long.parseLong(s[0]),Long.parseLong(s[1]), Long.parseLong(s[2])));
        }

        int n = nodes.size();
        List<DistancePair> distancePairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(nodes.get(i), nodes.get(j));
                distancePairs.add(new DistancePair(i, j, distance));
            }
        }

        distancePairs.sort(Comparator.comparingDouble(p -> p.result));

        DSU dsu = new DSU(n);
        for (int i = 0; i < Math.min(1000, distancePairs.size()); i++) {
            DistancePair p = distancePairs.get(i);
            dsu.union(p.node1, p.node2);
        }
        Map<Integer, Integer> nodesCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.findParent(i);
            nodesCnt.put(parent, nodesCnt.getOrDefault(parent, 0) + 1);
        }

        long ans = nodesCnt.values().stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToLong(Integer::longValue)
                .reduce(1L, (x, y) -> x * y);

        System.out.println(ans);
    }

    private static double calculateDistance(Node node1, Node node2) {
        long X = node1.x - node2.x;
        long Y = node1.y - node2.y;
        long Z = node1.z - node2.z;
        return Math.sqrt(X * X + Y * Y + Z * Z);
    }

    static class DistancePair {
        int node1;
        int node2;
        double result;

        DistancePair(int node1, int node2, double result) {
            this.node1 = node1;
            this.node2 = node2;
            this.result = result;
        }
    }

    static class Node {
        int id;
        long x;
        long y;
        long z;

        Node(int id, long x, long y, long z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int x) {
            if (parent[x] != x)
                parent[x] = findParent(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            a = findParent(a);
            b = findParent(b);
            if (a == b) return;
            if (size[a] < size[b]) {
                int t = a;
                a = b;
                b = t;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
