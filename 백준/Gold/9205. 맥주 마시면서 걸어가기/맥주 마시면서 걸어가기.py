import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        store = [list(map(int, input().split())) for _ in range(N + 2)]
        dp = [[0] * (N + 2) for _ in range(N + 2)]
        for i in range(N + 2):
            for j in range(N + 2):
                if i == j:
                    continue
                if abs(store[i][0] - store[j][0]) + abs(store[i][1] - store[j][1]) <= 1000:
                    dp[i][j] = 1
        for k in range(N + 2):
            for i in range(N + 2):
                for j in range(N + 2):
                    if dp[i][k] and dp[k][j]:
                        dp[i][j] = 1
        if dp[0][N + 1]:
            print('happy')
        else:
            print('sad')

if __name__ == '__main__':
    main()