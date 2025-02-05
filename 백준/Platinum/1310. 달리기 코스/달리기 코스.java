import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        
        public int compareTo(Point p) {
            if (this.x == p.x)
                return Long.compare(this.y, p.y);
            return Long.compare(this.x, p.x);
        }
    }

    
    static long cross(Point A, Point B, Point C) {
        return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
    }

    
    static long distSq(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        
        if (N == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        
        Arrays.sort(points);
        ArrayList<Point> hull = new ArrayList<>();

        
        for (int i = 0; i < N; i++) {
            while (hull.size() >= 2 && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }

        
        int lowerSize = hull.size();
        for (int i = N - 2; i >= 0; i--) {
            while (hull.size() > lowerSize
                    && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }

        
        hull.remove(hull.size() - 1);

        int hullSize = hull.size();
        if (hullSize == 1) { 
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        
        long maxDistSq = 0;
        int j = 1;
        for (int i = 0; i < hullSize; i++) {
            
            int nextI = (i + 1) % hullSize;
            
            while (true) {
                int nextJ = (j + 1) % hullSize;
                long cross1 = Math.abs(cross(hull.get(i), hull.get(nextI), hull.get(j)));
                long cross2 = Math.abs(cross(hull.get(i), hull.get(nextI), hull.get(nextJ)));
                if (cross2 > cross1) {
                    j = nextJ;
                } else {
                    break;
                }
            }
            
            maxDistSq = Math.max(maxDistSq, distSq(hull.get(i), hull.get(j)));
            maxDistSq = Math.max(maxDistSq, distSq(hull.get(nextI), hull.get(j)));
        }

        bw.write(String.valueOf(maxDistSq));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}