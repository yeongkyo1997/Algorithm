import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = input()
    P = input()
    pi = getPi(P)
    result = find(T, P, pi)
    print(len(result))
    print(*result)


def getPi(P):
    m = len(P)
    PI = [0] * m
    j = 0
    for i in range(1, m):
        while j > 0 and P[i] != P[j]:
            j = PI[j - 1]
        if P[i] == P[j]:
            j += 1
            PI[i] = j
    return PI


def find(T, P, pi):
    n, m = len(T), len(P)
    j = 0
    result = []
    for i in range(n):
        while j > 0 and T[i] != P[j]:
            j = pi[j - 1]
        if T[i] == P[j]:
            if j == m - 1:
                result.append(i - m + 2)
                j = pi[j]
            else:
                j += 1
    return result


if __name__ == '__main__':
    main()
