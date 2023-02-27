import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

# BOJ 10810 - 공 바꾸기
def main():
    N, M = map(int, input().split())
    arr = [0] * N
    for _ in range(M):
        i, j, k = map(int, input().split())
        for l in range(i - 1, j):
            arr[l] = k
    print(*arr)

if __name__ == '__main__':
    main()