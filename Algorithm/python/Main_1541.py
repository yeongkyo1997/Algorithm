import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    s = input().split('-')
    result = 0
    for i in s[0].split('+'):
        result += int(i)
    for i in s[1:]:
        for j in i.split('+'):
            result -= int(j)
    print(result)


if __name__ == '__main__':
    main()
