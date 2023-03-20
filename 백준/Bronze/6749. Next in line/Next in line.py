import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    Y = int(input())
    M = int(input())
    print(M + (M - Y))

if __name__ == '__main__':
    main()