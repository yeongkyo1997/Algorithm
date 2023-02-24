import math
import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

arr = []
MAX = 100001

def main():
    K = int(input())
    arr = [1 for _ in range(MAX + 1)]
    print(arr)
    
    for i in range(2, int(math.sqrt(MAX)) + 1):
        if arr[i] == 1:
            for j in range(i, MAX + 1, i):
                arr[j] *= -i
            for j in range(i * i, MAX + 1, i * i):
                arr[j] = 0
    
    for i in range(2, MAX + 1):
        if arr[i] == i:
            arr[i] = 1
        elif arr[i] == -i:
            arr[i] = -1
        elif arr[i] < 0:
            arr[i] = 1
        elif arr[i] > 0:
            arr[i] = -1
    
    start = 1
    end = 2000000000
    
    while start < end:
        mid = (start + end) >> 1
        tmp = solve(mid)
        if tmp > K:
            end = mid - 1
        elif tmp == K:
            end = mid
        else:
            start = mid + 1
    print(start)

def solve(N):
    result = 0
    
    for i in range(1, int(math.sqrt(N)) + 1):
        result += arr[i] * (N // (i ** 2))
    return result

if __name__ == '__main__':
    main()
