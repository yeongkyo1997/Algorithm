import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 13172
def main():
    m = int(input())
    ans = 0
    for _ in range(m):
        a, b = map(int, input().split())
        ans += a * b
    print(ans % 1000000007)


if __name__ == '__main__':
    main()
