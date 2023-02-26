import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 1107 리모컨
def main():
    n = int(input())
    m = int(input())
    if m:
        broken = set(input().split())
    else:
        broken = set()
    result = abs(n - 100)
    for i in range(1000001):
        for j in str(i):
            if j in broken:
                break
        else:
            result = min(result, abs(n - i) + len(str(i)))
    print(result)


if __name__ == '__main__':
    main()