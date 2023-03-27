import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    for i in sorted(set(itertools.combinations(sorted(map(int, input().split())), M))):
        print(*i)

if __name__ == '__main__':
    main()
