import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    L = int(input())
    S = input()
    sum = 0
    for i in range(L):
        sum += (ord(S[i]) - 96) * (31 ** i)

    print(sum % 1234567891)


if __name__ == '__main__':
    main()