import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    L = int(input())
    s = input()
    hash = 0
    for i in range(len(s)):
        hash += (ord(s[i]) - 96) * pow(31, i)
    print(hash % 1234567891)


if __name__ == '__main__':
    main()
