def factorial_mod(n, MOD):
    result = 1
    for i in range(2, n + 1):
        result = (result * i) % MOD
    return result


def solve(N):
    MOD = 10 ** 9 + 7

    pairs = N // 2

    factorial_N = factorial_mod(N, MOD)
    factorial_pairs = factorial_mod(pairs, MOD)
    power_two_pairs = pow(2, pairs, MOD)

    def mod_inverse(a, p):
        return pow(a, p - 2, p)

    factorial_pairs_inv = mod_inverse(factorial_pairs, MOD)

    total_ways = (factorial_N * factorial_pairs_inv % MOD) * mod_inverse(power_two_pairs, MOD) % MOD

    return total_ways


N = int(input())
print(solve(N))