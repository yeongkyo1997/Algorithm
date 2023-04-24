import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    L = int(input())
    pattern = input()
    pi = getPi(pattern)
    print(L - pi[len(pattern) - 1])


def getPi(pattern):
    length = len(pattern)
    pi = [0] * length
    j = 0
    for i in range(1, length):
        while j > 0 and pattern[i] != pattern[j]:
            j = pi[j - 1]
        if pattern[i] == pattern[j]:
            j += 1
            pi[i] = j
    return pi


if __name__ == '__main__':
    main()
