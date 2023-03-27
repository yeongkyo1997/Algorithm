import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(m)]
    

if __name__ == '__main__':
    main()
