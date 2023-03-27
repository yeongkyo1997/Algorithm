def power(num, t):
    if t == 1:
        return num % MOD
    elif t % 2:
        return num * power(num, t - 1) % MOD
    else:
        p = power(num, t // 2)
        return p * p % MOD

M = int(input())
MOD = (10 ** 9) + 7
result = 0

for _ in range(M):
    n, s = map(int, input().split())
    result += s * power(n, MOD - 2) % MOD
print(result % MOD)