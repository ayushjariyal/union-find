import java.util.*;

class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Chase parent pointer until reach root

    private int root(int i) {
        while (i != id[i]) 
            i = id[i];
            return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}

public class LazyAppUF {
    public static void main(String[] args) {

        System.out.print("Enter number of elements: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        QuickFindUF uf = new QuickFindUF(a);

        System.out.print("Enter how many times you want to check if elements are connected or not: ");
        Scanner count = new Scanner(System.in);
        int c = count.nextInt();

        for(int i = 0; i < c; i++) {
            System.out.println("Enter " + i + " number Elements: " );
            Scanner x = new Scanner(System.in);
            int X = x.nextInt();
            Scanner y = new Scanner(System.in);
            int Y = y.nextInt();

            if (uf.connected(X, Y)) {
                System.out.println(X + " and " + Y + " are connected.");
            }
            else {
                System.out.println(X + " and " + Y + " are not connected.");

                System.out.println("If you want to connect " + X + " and " + Y + " Enter 1.");
                Scanner in = new Scanner(System.in);
                int inp = in.nextInt();

                if (inp == 1) {
                    uf.union(X, Y);
                    System.out.println(X + " and " + Y + " are now connected.");
                }
            }
        }
    }
}