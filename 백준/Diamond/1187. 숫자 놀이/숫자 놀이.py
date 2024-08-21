import sys

input = lambda: sys.stdin.readline().rstrip()


def dnc(l, r):
    N = (r - l + 2) // 2
    if N <= 1:
        return a[l]
    h = [0] * 3
    for i in range(3):
        h[i] = dnc(l + i * (N // 2), l + i * (N // 2) + N - 2) // (N // 2)
    if h[0] % 2 == h[1] % 2:
        return (h[0] + h[1]) * (N // 2)
    elif h[0] % 2 == h[2] % 2:
        for i in range(N // 2):
            a[l + i + N // 2], a[l + i + N] = a[l + i + N], a[l + i + N // 2]
        return (h[0] + h[2]) * (N // 2)
    else:
        for i in range(N // 2):
            a[l + i], a[l + i + N] = a[l + i + N], a[l + i]
        return (h[2] + h[1]) * (N // 2)


n = int(input())
a = list(map(int, input().split()))

dnc(0, 2 * (n - 1))

print(*a[:n])