import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        pattern = input()

        if pattern == '.':
            break

        pi = getPi(pattern)

        if len(pattern) % (len(pattern) - pi[len(pattern) - 1]) != 0:
            print(1)
        else:
            print(len(pattern) // (len(pattern) - pi[len(pattern) - 1]))


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


if __name__ == '__main__':
    main()
