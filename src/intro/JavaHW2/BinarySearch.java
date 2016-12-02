package intro.JavaHW2;

public class BinarySearch {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] m = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            m[i] = Integer.parseInt(args[i + 1]);
        }
//        System.out.println(normalSearch(m, x));
        System.out.println(recursiveSearch(m, x, 0, m.length));
    }

    public static  int normalSearch(int[] m, int x) {
        int idxL = 0;
        int idxR = m.length;
        while (idxL + 1 < idxR) {
            int mid = (idxL + idxR) / 2;
            if (m[mid] > x) {
                idxL = mid;
            } else {
                idxR = mid;
            }
        }
        if (idxL + 1 == idxR && m[idxL] <= x) {
            idxR = idxL;
        }
        return idxR;
    }
    public static int recursiveSearch(int[] m, int x, int idxL, int idxR) {
        if (idxL + 1 < idxR)  {
            int mid = (idxL + idxR) / 2;
            if (m[mid] > x) {
                return recursiveSearch(m, x, mid, idxR);
            } else {
                return recursiveSearch(m, x, idxL, mid);
            }
        } else {
            if (idxL + 1 == idxR && m[idxL] <= x) {
                idxR = idxL;
            }
            return idxR;
        }
    }
}