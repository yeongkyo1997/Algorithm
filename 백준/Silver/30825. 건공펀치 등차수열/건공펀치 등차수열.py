import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    start = arr[0]
    result = 0
    results = []
    while True:
        for idx, i in enumerate(range(arr[0], arr[0] + len(arr) * K, K)):
            if i - arr[idx] >= 0:
                result += i - arr[idx]
                results.append(i)
            else:
                arr[0] += arr[idx] - i
                results = []
                result = 0
                break
        else:
            break
    print(result + (arr[0] - start))