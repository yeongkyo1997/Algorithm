import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, B = map(int, input().split())
    A = [list(map(int, input().split())) for _ in range(N)]
    result = [[0] * N for _ in range(N)]
    for i in range(N):
        result[i][i] = 1
    while B:
        if B % 2:
            result = myPow(result, A)
        A = myPow(A, A)
        B //= 2
    for i in range(N):
        print(*result[i])

def myPow(A, B):
    N = len(A)
    result = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                result[i][j] += A[i][k] * B[k][j]
            result[i][j] %= 1000
    return result

if __name__ == '__main__':
    main()