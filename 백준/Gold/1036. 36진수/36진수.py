def solve(n):
    q = n // 36
    r = n % 36
    return solve(q) + (chr(r + 48) if 0 <= r <= 9 else chr(r + 55)) if q else chr(r + 48) if 0 <= r <= 9 else chr(
        r + 55)

N = int(input())
hex = [0] * 36

for i in range(N):
    n = input()
    l = len(n)
    for j in range(l):
        hex[int(n[j], 36)] += 36 ** (l - j - 1)

K = int(input())
A = [[hex[i] * (35 - i), i] for i in range(36)]
A.sort()
print(solve(sum(map(lambda x: hex[A[x][1]] * (A[x][1] if x < 36 - K else 35), range(36)))))