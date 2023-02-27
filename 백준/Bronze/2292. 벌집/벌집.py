import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    if n == 1:
        print(1)
        return
    n -= 1
    cnt = 1
    while n > 0:
        n -= 6 * cnt
        cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()