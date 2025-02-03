import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        boolean[] oneShot = new boolean[200001];
        int maxShot = 0;
        for (int i = 0; i < N; i++) {
            int dist = Integer.parseInt(br.readLine().trim());
            if (dist < oneShot.length) {
                oneShot[dist] = true;
            }
            if (dist > maxShot)
                maxShot = dist;
        }

        int size = 1;
        while (size < 2 * maxShot + 1)
            size <<= 1;

        Complex[] fa = new Complex[size];
        for (int i = 0; i < size; i++) {
            if (i < oneShot.length) {
                fa[i] = new Complex(oneShot[i] ? 1.0 : 0.0, 0.0);
            } else {
                fa[i] = new Complex(0.0, 0.0);
            }
        }

        fft(fa, false);

        for (int i = 0; i < size; i++) {
            fa[i] = fa[i].mul(fa[i]);
        }

        fft(fa, true);

        boolean[] possible = new boolean[200001];
        for (int d = 1; d <= 200000; d++) {
            boolean can = false;

            if (d < oneShot.length && oneShot[d]) {
                can = true;
            }

            if (!can && d <= 2 * maxShot && d < fa.length) {

                if (fa[d].re > 0.5) {
                    can = true;
                }
            }
            possible[d] = can;
        }

        int M = Integer.parseInt(br.readLine().trim());
        int count = 0;
        for (int i = 0; i < M; i++) {
            int hole = Integer.parseInt(br.readLine().trim());
            if (hole <= 200000 && possible[hole]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static void fft(Complex[] a, boolean invert) {
        int n = a.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; j >= bit; bit >>= 1)
                j -= bit;
            j += bit;
            if (i < j) {
                Complex temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double angle = 2 * Math.PI / len * (invert ? -1 : 1);
            Complex wlen = new Complex(Math.cos(angle), Math.sin(angle));
            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    Complex u = a[i + j];
                    Complex v = a[i + j + len / 2].mul(w);
                    a[i + j] = u.add(v);
                    a[i + j + len / 2] = u.sub(v);
                    w = w.mul(wlen);
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i].re /= n;
                a[i].im /= n;
            }
        }
    }

    static class Complex {
        double re, im;

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public Complex add(Complex other) {
            return new Complex(this.re + other.re, this.im + other.im);
        }

        public Complex sub(Complex other) {
            return new Complex(this.re - other.re, this.im - other.im);
        }

        public Complex mul(Complex other) {
            return new Complex(this.re * other.re - this.im * other.im,
                    this.re * other.im + this.im * other.re);
        }
    }
}