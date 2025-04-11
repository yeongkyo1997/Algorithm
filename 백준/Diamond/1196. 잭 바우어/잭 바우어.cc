#include <iostream>
#include <iomanip>
#include <cmath> 

const long double GAMMA = 0.57721566490153286060651209008240243104215933593992L;

long double harmonic_exact(long long n) {
    if (n <= 0) return 0.0L;
    long double sum = 0.0L;
    for (long long i = 1; i <= n; ++i) {
        sum += 1.0L / static_cast<long double>(i);
    }
    return sum;
}

long double harmonic_approx(long long n) {
    if (n <= 0) return 0.0L;
    long double n_ld = static_cast<long double>(n);
    long double n2 = n_ld * n_ld;
    long double n4 = n2 * n2;
    return logl(n_ld) + GAMMA + 1.0L / (2.0L * n_ld) - 1.0L / (12.0L * n2) + 1.0L / (120.0L * n4);
}

long double harmonic_diff_approx_log1p(long long n_ll, long long m_ll) {

    long double n_ld = static_cast<long double>(n_ll);
    long double m_ld = static_cast<long double>(m_ll);
    long double k_ld = n_ld - m_ld; 

    long double term1 = log1pl(k_ld / m_ld);

    long double n2 = n_ld * n_ld;
    long double m2 = m_ld * m_ld;
    long double n4 = n2 * n2;
    long double m4 = m2 * m2;

    long double term2 = (1.0L / (2.0L * n_ld)) - (1.0L / (2.0L * m_ld));
    long double term3 = -((1.0L / (12.0L * n2)) - (1.0L / (12.0L * m2)));
    long double term4 = (1.0L / (120.0L * n4)) - (1.0L / (120.0L * m4));

    return term1 + term2 + term3 + term4;
}


int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    long long n_ll, k_ll;
    std::cin >> n_ll >> k_ll;

    if (k_ll <= 0) {
        std::cout << std::fixed << std::setprecision(15) << 0.0L << std::endl;
        return 0;
    }
    if (k_ll > n_ll) { 
        k_ll = n_ll;
    }

    long double n_ld = static_cast<long double>(n_ll);
    long double expected_value = 0.0L;
    const long long THRESHOLD = 1000000; 
    long long d_ll = n_ll - k_ll; // N-K

    if (k_ll <= THRESHOLD) {
        for (long long i = 0; i < k_ll; ++i) {
            expected_value += n_ld / (n_ld - static_cast<long double>(i));
        }
    }
    else if (d_ll <= THRESHOLD) {
        long double h_n_approx = harmonic_approx(n_ll);
        long double h_n_minus_k_exact = harmonic_exact(d_ll); 
        expected_value = n_ld * (h_n_approx - h_n_minus_k_exact);
    }
    else {
        long double h_diff = harmonic_diff_approx_log1p(n_ll, d_ll);
        expected_value = n_ld * h_diff;
    }

    std::cout << std::fixed << std::setprecision(15) << expected_value << std::endl;

    return 0;
}