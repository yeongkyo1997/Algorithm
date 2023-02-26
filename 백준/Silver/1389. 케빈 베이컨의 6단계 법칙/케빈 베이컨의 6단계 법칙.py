import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    arr = [[0] * (n + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        arr[i][i] = 1

    for _ in range(m):
        a, b = map(int, input().split())
        arr[a][b] = 1
        arr[b][a] = 1

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if arr[i][k] and arr[k][j]:
                    if arr[i][j] == 0:
                        arr[i][j] = arr[i][k] + arr[k][j]
                    else:
                        arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
    result = 0
    minVal = 1000000000
    for i in range(1, n + 1):
        if sum(arr[i]) < minVal:
            minVal = sum(arr[i])
            result = i
    print(result)


if __name__ == '__main__':
    main()