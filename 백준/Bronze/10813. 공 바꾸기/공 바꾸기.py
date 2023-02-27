import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]
    
    for _ in range(M):
        i, j = map(int, input().split())
        arr[i - 1], arr[j - 1] = arr[j - 1], arr[i - 1]
    print(*arr)

if __name__ == '__main__':
    main()