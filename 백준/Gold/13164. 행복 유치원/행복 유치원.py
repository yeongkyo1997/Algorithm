import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, K = map(int, input().split())
    heights = list(map(int, input().split()))
    diff = []
    for i in range(1, N):
        diff.append(heights[i] - heights[i - 1])
    diff.sort(reverse=True)
    print(sum(diff[K - 1:]))

if __name__ == '__main__':
    main()