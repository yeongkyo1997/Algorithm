import sys


def input(): return sys.stdin.readline().rstrip()


def make_pi(pattern):
    m = len(pattern)
    pi = [0] * m

    length = 0
    i = 1

    while i < m:
        if pattern[i] == pattern[length]:
            length += 1
            pi[i] = length
            i += 1
        else:
            if length != 0:
                length = pi[length - 1]
            else:
                pi[i] = 0
                i += 1

    return pi


def kmp_search(text, p):
    n = len(text)
    m = len(p)
    pi = make_pi(p)
    result = []

    i = 0
    j = 0

    while i < n:
        if p[j] == text[i]:
            i += 1
            j += 1

        if j == m:
            result.append(i - j + 1)
            j = pi[j - 1]

        elif i < n and p[j] != text[i]:
            if j != 0:
                j = pi[j - 1]
            else:
                i += 1

    return result


T = input()
P = input()

pos = kmp_search(T, P)

cnt = len(pos)
print(cnt)
print(*pos)