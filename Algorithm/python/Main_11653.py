import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n = int(input())
    i = 2
    while n != 1:
        if n % i == 0:
            print(i)
            n //= i
        else:
            i += 1

if __name__ == '__main__':
    main()
