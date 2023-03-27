import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    T = int(input())
    while T:
        T -= 1
        arr = map(int, input().split(','))
        print(sum(arr))

if __name__ == '__main__':
    main()