import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.append(list(input()))
    result = 100000000000000000000
    for i in range(n - 7):
        for j in range(m - 7):
            cnt = 0
            for k in range(i, i + 8):
                for l in range(j, j + 8):
                    if (k + l) % 2 == 0:
                        if arr[k][l] == 'B':
                            cnt += 1
                    else:
                        if arr[k][l] == 'W':
                            cnt += 1
            if cnt > 32:
                cnt = 64 - cnt
            if result > cnt:
                result = cnt
    print(result)


if __name__ == '__main__':
    main()
