
import java.util.*;
import java.io.*;

class DoubleTriple implements Comparable<DoubleTriple> {
    Double _first;
    Integer _second, _third;

    public DoubleTriple(Double f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(DoubleTriple o) {
        return Double.compare(this.first(), o.first());
    }

    Double first() {
        return _first;
    }

    Integer second() {
        return _second;
    }

    Integer third() {
        return _third;
    }

    public String toString() {
        return first() + " " + second() + " " + third();
    }
}

class UnionFind {
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<Integer>(N);
        rank = new ArrayList<Integer>(N);
        setSize = new ArrayList<Integer>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i)
            return i;
        else {
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;
            int x = findSet(i), y = findSet(j);
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y))
                    rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
    }
}

class treehouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int e = Integer.parseInt(tokens[1]);
        int p = Integer.parseInt(tokens[2]);
        ArrayList<DoubleTriple> EL = new ArrayList<>();
        double[][] treehouse_coor = new double[n][2];
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            double x = Double.parseDouble(tokens[0]);
            double y = Double.parseDouble(tokens[1]);
            treehouse_coor[i][0] = x;
            treehouse_coor[i][1] = y;
        }
        for (int i = 0; i < e; i++) {
            EL.add(new DoubleTriple(0.0, n, i));
        }
        for (int i = 0; i < p; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            EL.add(new DoubleTriple(0.0, a - 1, b - 1));
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                double dist = Math.hypot(treehouse_coor[i][0] - treehouse_coor[j][0],
                        treehouse_coor[i][1] - treehouse_coor[j][1]);
                EL.add(new DoubleTriple(dist, i, j));
            }
        }
        double cost = 0;
        Collections.sort(EL);
        UnionFind UF = new UnionFind(n + 1);
        for (DoubleTriple edge : EL) {
            if (!UF.isSameSet(edge.second(), edge.third())) {
                cost = cost + edge.first();
                UF.unionSet(edge.second(), edge.third());
            }
        }
        pw.printf("%.6f\n", cost);
        pw.close();
    }
}