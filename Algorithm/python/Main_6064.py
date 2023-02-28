import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    t = int(input())
    for _ in range(t):
        m, n, x, y = map(int, input().split())
        x -= 1
        y -= 1
        ans = -1
        for i in range(x, m * n, m):
            if i % n == y:
                ans = i + 1
                break
        print(ans)


if __name__ == '__main__':
    main()
