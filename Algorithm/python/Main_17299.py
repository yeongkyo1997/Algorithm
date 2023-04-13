import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))
stack = []
cnt = collections.defaultdict(lambda: 0)

for i in range(N):
    cnt[arr[i]] += 1

for i in range(N):
    while stack and cnt[stack[-1]] < cnt[arr[i]]:
        stack.pop()
    if stack:
        print(stack[-1], end=' ')
    else:
        print(-1, end=' ')
    stack.append(arr[i])

