import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    quarter = 25
    dime = 10
    nickel = 5
    penny = 1

    for _ in range(int(input())):
        n = int(input())
        print(n // quarter, end=' ')
        n %= quarter
        print(n // dime, end=' ')
        n %= dime
        print(n // nickel, end=' ')
        n %= nickel
        print(n // penny)


main()