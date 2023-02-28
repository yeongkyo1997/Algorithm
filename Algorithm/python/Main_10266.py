import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 10266 시계 사진들
def main():
    n = int(input())
    arr1 = map(int, input().split())
    arr2 = map(int, input().split())

    arr1 = list(arr1)
    arr2 = list(arr2)

    arr1.sort()
    arr2.sort()

    arr1 = arr1 + arr1
    arr2 = arr2 + arr2

    for i in range(n):
        arr2[i] = arr2[i + n] - arr2[i]
    arr2 = arr2[:n]

    for i in range(n):
        arr2[i] = arr2[i] % 360000
    arr2.sort()

    for i in range(n):
        arr1[i] = arr1[i + n] - arr1[i]
    arr1 = arr1[:n]

    for i in range(n):
        arr1[i] = arr1[i] % 360000
    arr1.sort()

    if arr1 == arr2:
        print('possible')
    else:
        print('impossible')


if __name__ == '__main__':
    main()
