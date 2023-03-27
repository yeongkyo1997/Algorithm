import sys

input = sys.stdin.readline

for _ in range(3):
    total = list(map(int, input().split()))
    arr1, arr2 = total[:3], total[3:]
    sum2 = arr2[0] * 3600 + arr2[1] * 60 + arr2[2]
    sum1 = arr1[0] * 3600 + arr1[1] * 60 + arr1[2]
    result = sum2 - sum1

    h = result // 3600
    result %= 3600

    M = result // 60
    result %= 60

    s = result

    print(h, M, s)
