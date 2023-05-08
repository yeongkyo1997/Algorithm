import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
pattern = input()
input = input() + input()


def makeFailureTable(pattern):
    lenP = len(pattern)
    F = [0] * lenP

    j = 0
    for i in range(1, lenP):
        while j > 0 and pattern[i] != pattern[j]:
            j = F[j - 1]
        if pattern[i] == pattern[j]:
            j += 1
            F[i] = j

    return F


def KMP(str, pattern, F):
    lenS = len(str)
    lenP = len(pattern)

    res = 0

    j = 0
    for i in range(lenS - 1, -1, -1):
        while j > 0 and str[i] != pattern[j]:
            j = F[j - 1]
        if str[i] == pattern[j]:
            if j == lenP - 1:
                res += 1
                j = F[j]
            else:
                j += 1

    return res


F = makeFailureTable(pattern)
res = KMP(input, pattern, F)

while res != 1 and N % res == 0:
    N //= res
    res //= res

print("{}/{}".format(res, N))
