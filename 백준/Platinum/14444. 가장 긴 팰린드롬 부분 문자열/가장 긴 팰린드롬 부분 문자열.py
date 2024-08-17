import sys

input = lambda: sys.stdin.readline().rstrip()


def longest_palindrome(s):
    T = '#' + '#'.join(s) + '#'
    n = len(T)
    P = [0] * n
    C = 0
    R = 0

    for i in range(n):
        mirror = 2 * C - i

        if i < R:
            P[i] = min(R - i, P[mirror])

        a, b = i + P[i] + 1, i - P[i] - 1
        while a < n and b >= 0 and T[a] == T[b]:
            P[i] += 1
            a += 1
            b -= 1

        if i + P[i] > R:
            C = i
            R = i + P[i]

    ret = max(P)
    return ret


s = input()
print(longest_palindrome(s))