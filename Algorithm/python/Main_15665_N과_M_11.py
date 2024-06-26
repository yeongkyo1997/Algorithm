import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    
    for i in sorted(set(itertools.product(sorted(map(int, input().split())), repeat=M))):
        print(*i)

if __name__ == '__main__':
    main()
