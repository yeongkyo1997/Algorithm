import java.util.*;
import java.math.BigInteger;

public class Main_13727_5차원_구사과_초콜릿 {
    static final int MOD = 1_000_000_007;

    static long _pow(long x, long p) {
        BigInteger ret = BigInteger.ONE;
        BigInteger piv = BigInteger.valueOf(x);
        BigInteger mod = BigInteger.valueOf(MOD);

        while (p != 0) {
            if ((p & 1) == 1) {
                ret = ret.multiply(piv).mod(mod);
            }
            piv = piv.multiply(piv).mod(mod);
            p >>= 1;
        }
        return ret.longValue();
    }

    static List<Integer> berlekamp_massey(List<Integer> x) {
        List<Integer> ls = new ArrayList<>(), cur = new ArrayList<>();
        int lf = 0, ld = 0;
        for (int i = 0; i < x.size(); i++) {
            long t = 0;
            for (int j = 0; j < cur.size(); j++) {
                t = (t + (long) x.get(i - j - 1) * cur.get(j)) % MOD;
            }
            if ((t - x.get(i)) % MOD == 0) {
                continue;
            }
            if (cur.isEmpty()) {
                cur = new ArrayList<>(Collections.nCopies(i + 1, 0));
                lf = i;
                ld = (int) ((t - x.get(i)) % MOD);
                continue;
            }
            long k = -(x.get(i) - t) * _pow(ld, MOD - 2) % MOD;
            List<Integer> c = new ArrayList<>(Collections.nCopies(i - lf - 1, 0));
            c.add((int) k);
            for (int j : ls) {
                c.add((int) (-j * k % MOD));
            }
            if (c.size() < cur.size()) {
                while (c.size() < cur.size()) {
                    c.add(0);
                }
            }
            for (int j = 0; j < cur.size(); j++) {
                c.set(j, (c.get(j) + cur.get(j)) % MOD);
            }
            if (i - lf + ls.size() >= cur.size()) {
                ls = cur;
                lf = i;
                ld = (int) ((t - x.get(i)) % MOD);
            }
            cur = c;
        }

        for (int i = 0; i < cur.size(); i++) {
            cur.set(i, (cur.get(i) % MOD + MOD) % MOD);
        }
        return cur;
    }

    static int get_nth(List<Integer> rec, List<Integer> dp, long n) {
        int m = rec.size();
        List<Integer> s = new ArrayList<>(Collections.nCopies(m, 0));
        s.set(0, 1);
        List<Integer> t;
        if (m != 1) {
            t = new ArrayList<>(Collections.nCopies(m, 0));
            t.set(1, 1);
        } else {
            t = new ArrayList<>(Collections.nCopies(m, rec.get(0)));
        }

        while (n != 0) {
            if ((n & 1) == 1) {
                s = mul(rec, s, t);
            }
            t = mul(rec, t, t);
            n >>= 1;
        }

        long ret = 0;
        for (int i = 0; i < m; i++) {
            ret += (long) s.get(i) * dp.get(i) % MOD;
        }
        return (int) (ret % MOD);
    }

    static List<Integer> mul(List<Integer> rec, List<Integer> v, List<Integer> w) {
        int m = v.size();
        List<Integer> t = new ArrayList<>(Collections.nCopies(2 * m, 0));

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                t.set(j + k, (int) ((t.get(j + k) + (long) v.get(j) * w.get(k) % MOD) % MOD));
            }
        }

        for (int j = 2 * m - 1; j >= m; j--) {
            for (int k = 1; k <= m; k++) {
                t.set(j - k, (int) ((t.get(j - k) + (long) t.get(j) * rec.get(k - 1) % MOD) % MOD));
            }
        }
        t.subList(m, t.size()).clear();
        return t;
    }

    static int guess_nth_term(List<Integer> x, long n) {
        if (n < x.size()) {
            return x.get((int) n);
        }
        List<Integer> v = berlekamp_massey(x);
        if (v.isEmpty()) {
            return 0;
        }
        return get_nth(v, x, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> v = Arrays.asList(1, 272, 589185, 930336768, 853401154, 217676188, 136558333, 415722813, 985269529, 791527976, 201836136, 382110354, 441223705, 661537677, 641601343, 897033284, 816519670, 365311407, 300643484, 936803543, 681929467, 462484986, 13900203, 657627114, 96637209, 577140657, 600647073, 254604056, 102389682, 811580173, 592550067, 587171680, 526467503, 265885773, 951722780, 219627841, 371508152, 283501391, 159234514, 439380999, 722868959, 125599834, 351398134, 456317548, 365496182, 614778702, 502680047, 193063685, 309004764, 743901785, 870955115, 312807829, 160375015, 691844624, 137034372, 350330868, 895680450, 282610535, 317897557, 28600551, 583305647, 539409363, 327406961, 627805385, 680183978, 681299085, 954964592, 743524009, 788048339, 699454626, 666369521, 857206425, 490463127, 477198247, 599963928, 21247982, 107843532, 753662937, 239039324, 608530376, 523383010, 654448101, 801430395, 393034561, 93313778, 983052766, 240336620, 825539982, 525118275, 563899476, 706271688, 547405697, 477082486, 664058071, 353207278, 729486413, 795704637, 999271072, 540749624, 411451016, 736422999, 879369181, 918733916, 982303557, 512499644, 261033810, 391766409, 334092786, 931794834, 854181848, 821090190, 751839258, 433126935, 571194155, 52438113, 552977155, 320805296, 173355929, 969659468, 258854248, 159509877, 374487748, 401382023, 44060530, 510164669, 336596764, 652050424, 373872552, 517226592, 719871041, 43959496, 235333335, 304962191, 253114421, 43638769, 361871585, 8060121, 147014624, 114846460, 430864038, 368951246, 863795701, 36066788, 971606149, 935875286, 486724123, 73790652, 236936530, 307697424, 753314001, 40450345, 529462842, 166162047, 974102330, 600865526, 63237062, 749041914, 670937123, 806399597, 776678839, 842565920, 608499253, 469062485, 842196981, 247762946, 778570576, 237951782, 286343384, 988318575, 147255879, 905747089, 711062313, 21396079, 826846622, 443781794, 786474911, 400737121, 844768961, 686214818, 590050845, 855473150, 18501778, 33258755, 398169058, 811192244, 710397887, 591757177, 775311969, 168256434, 509615161, 489764304, 605188191, 498085780, 164388183, 524662873, 322602324, 853641480, 205349527, 308211944, 93153206);
        long n = scanner.nextLong();
        System.out.println(guess_nth_term(v, n));
    }
}