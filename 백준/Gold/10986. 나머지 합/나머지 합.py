import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    mod = [0] * M
    mod[0] = 1
    cur = 0
    for i in range(N):
        cur += arr[i]
        mod[cur % M] += 1
    print(sum([i * (i - 1) // 2 for i in mod]))

if __name__ == '__main__':
    main()