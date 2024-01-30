import sys


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())
arr = list(map(int, input().split()))

s = sum(arr[:K])
result = s

left = 0
right = K - 1

while True:
    s -= arr[left]
    left += 1
    right += 1
    if right >= N:
        break
    s += arr[right]
    result = max(result, s)

print(result)