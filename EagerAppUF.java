import java.util.*;

class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];

        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}

public class EagerAppUF {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int N = scanner.nextInt();

        QuickFindUF uf = new QuickFindUF(N);

        System.out.println("Enter pairs of integers: ");

        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);

        int A = a.nextInt();
        int B = b.nextInt();
        
        System.out.println(uf.connected(A, B));

        if (uf.connected(A, B) == false) {
            uf.union(A, B);
        }

        System.out.println(A + " and " + B + " are now connected.");

        System.out.println("Again enter pair of integers to check if they are connected or not: ");
        Scanner c = new Scanner(System.in);
        Scanner d = new Scanner(System.in);

        int C = c.nextInt();
        int D = d.nextInt();

        System.out.println(uf.connected(C, D));
    }
}