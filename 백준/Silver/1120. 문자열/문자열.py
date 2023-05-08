import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    a, b = map(str, input().split())

    result = 50
    for i in range(len(b) - len(a) + 1):
        cnt = 0
        for j in range(len(a)):
            if a[j] != b[i + j]:
                cnt += 1
        result = min(result, cnt)
    print(result)


if __name__ == '__main__':
    main()