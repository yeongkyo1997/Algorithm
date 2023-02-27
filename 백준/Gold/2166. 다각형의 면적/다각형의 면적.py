import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    points = [list(map(int, input().split())) for _ in range(N)]
    points.append(points[0])
    result = 0
    for i in range(N):
        result += points[i][0] * points[i + 1][1] - points[i + 1][0] * points[i][1]
    print(round(abs(result) / 2, 1))

if __name__ == '__main__':
    main()