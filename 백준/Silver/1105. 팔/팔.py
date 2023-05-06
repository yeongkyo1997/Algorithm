import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    a, b = input().split()

    if len(a) != len(b):
        print(0)
        return

    result = 0
    for i in range(len(a)):
        if a[i] == b[i] and a[i] == '8':
            result += 1
        elif a[i] != b[i]:
            break
    print(result)


if __name__ == '__main__':
    main()