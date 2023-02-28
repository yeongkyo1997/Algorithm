import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    max_sum = sum(arr[:K])
    cur = max_sum
    for i in range(K, N):
        cur += arr[i] - arr[i - K]
        max_sum = max(max_sum, cur)
    print(max_sum)

if __name__ == '__main__':
    main()