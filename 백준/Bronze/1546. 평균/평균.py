import statistics
import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n = int(input())
    arr = list(map(int, input().split()))
    MAX = max(arr)
    arr = map(lambda x: (x / MAX * 100), arr)
    print(statistics.mean(arr))

if __name__ == '__main__':
    main()