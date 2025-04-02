import sys


def solve():

    n_str = sys.stdin.readline().strip()
    n = int(n_str)

    start_m = max(1, n - 9 * len(n_str))

    found = False
    for m in range(start_m, n):

        sum_digits = 0
        temp_m = m
        while temp_m > 0:
            sum_digits += temp_m % 10
            temp_m //= 10

        decomposition_sum = m + sum_digits

        if decomposition_sum == n:
            print(m)
            found = True
            break

    if not found:
        print(0)


solve()
