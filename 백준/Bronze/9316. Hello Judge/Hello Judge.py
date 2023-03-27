import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    for i in range(1, int(input()) + 1):
        print("Hello World, Judge %d!" % i)

if __name__ == '__main__':
    main()