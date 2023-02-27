import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, K = map(int, input().split())
    result = 0
    while True:
        if bin(N).count('1') <= K:
            break
        N += 1
        result += 1
    print(result)


if __name__ == '__main__':
    main()