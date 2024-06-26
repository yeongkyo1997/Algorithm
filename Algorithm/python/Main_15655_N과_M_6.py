import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    arr = map(int, input().split())
    
    for i in itertools.combinations(sorted(arr), M):
        print(*i)

if __name__ == '__main__':
    main()
