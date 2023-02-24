import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    arr = map(int, input().split())
    for i in itertools.product(sorted(arr), repeat=M):
        print(*i)

if __name__ == '__main__':
    main()