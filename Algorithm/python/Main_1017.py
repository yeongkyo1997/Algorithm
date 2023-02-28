import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 1017 소수 쌍
def main():
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    arr = arr + arr
    cnt = 0
    for i in range(n):
        arr[i] = arr[i + n] - arr[i]
    arr = arr[:n]
    for i in range(n):
        arr[i] = arr[i] % 360000
    arr.sort()
    for i in range(n):
        for j in range(i + 1, n):
            if arr[i] == arr[j]:
                cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()
