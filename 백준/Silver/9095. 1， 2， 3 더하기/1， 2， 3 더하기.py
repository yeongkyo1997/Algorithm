def ways_to_sum(n, memo):
    if n == 0:
        return 1
    if n < 0:
        return 0
    if memo[n] != -1:
        return memo[n]

    memo[n] = ways_to_sum(n - 1, memo) + ways_to_sum(n - 2, memo) + ways_to_sum(n - 3, memo)
    return memo[n]


def main():
    T = int(input())
    for _ in range(T):
        n = int(input())
        memo = [-1] * (n + 1)
        print(ways_to_sum(n, memo))


if __name__ == "__main__":
    main()