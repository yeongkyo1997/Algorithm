import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()


def main():
    a = [int(input()) for _ in range(4)]
    b = [int(input()) for _ in range(2)]
    
    a.sort()
    b.sort()
    
    print(sum(a[1:]) + b[1])

if __name__ == '__main__':
    main()
