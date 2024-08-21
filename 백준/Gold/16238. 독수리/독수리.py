import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    v = list(map(int, input().split()))

    result = 0
    for i in range(n):
        max_value = max(v)
        result += max(max_value - i, 0)
        v[v.index(max_value)] = 0

    print(result)


if __name__ == "__main__":
    main()