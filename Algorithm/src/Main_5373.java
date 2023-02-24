//import java.util.List;
//
//public class Main_5373 {
//    static int T;
//    static int N;
//
//    static List<List<Character>> clock(List<List<Character>> a) {
//        char tmp = a.get(0).get(0);
//
//        a.get(0).set(0, a.get(2).get(0));
//        a.get(2).set(0, a.get(2).get(2));
//        a.get(2).set(2, a.get(0).get(2));
//        a.get(0).set(2, tmp);
//
//        tmp = a.get(0).get(1);
//        a.get(0).set(1, a.get(1).get(0));
//        a.get(1).set(0, a.get(2).get(1));
//        a.get(2).set(1, a.get(1).get(2));
//        a.get(1).set(2, tmp);
//
//        return a;
//    }
//
//    static List<List<List<Character>>> U(List<List<List<Character>>> a) {
//        List<List<Character>> tmp = a.get(5);
//
//        a.set(5, a.get(0));
//        a.set(0, a.get(4));
//        a.set(4, a.get(1));
//        a.set(1, tmp);
//
//        clock(a.get(1));
//        clock(a.get(1));
//        clock(a.get(4));
//        clock(a.get(4));
//        clock(a.get(2));
//        clock(a.get(3));
//        clock(a.get(3));
//        clock(a.get(3));
//    }
//}