import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    for _ in range(int(input())):
        N = int(input())
        print(sum(map(int, input().split())))

if __name__ == '__main__':
    main()