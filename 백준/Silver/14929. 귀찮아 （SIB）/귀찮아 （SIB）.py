import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    x = list(map(int, input().split()))

    sum_x = sum(x)
    sum_x_square = sum([xi ** 2 for xi in x])
    result = (sum_x ** 2 - sum_x_square) // 2
   
    print(result)


if __name__ == '__main__':
    main()