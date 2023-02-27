# BOJ 5525 IOIOI

import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    m = int(input())
    s = input()
    correct = 'I' + 'OI' * n
    cnt = 0
    for i in range(m - 2 * n):
        if s[i:i + 2 * n + 1] == correct:
            cnt += 1

    print(cnt)


if __name__ == '__main__':
    main()