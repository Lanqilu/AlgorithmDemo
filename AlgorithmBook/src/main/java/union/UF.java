package union;

import edu.princeton.cs.algs4.StdIn;

import java.security.PublicKey;

/**
 * @author lanqilu
 * @date Created in 2020/09/22  22:34
 * @description
 */
public class UF {
    // 分量id(以触点作为索引)
    private int[] id;
    // number of components
    private int count;

    public UF(int N) {
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return 0;
    }

    public void union(int p, int q) {
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();

    }
}
