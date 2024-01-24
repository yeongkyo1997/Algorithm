from collections import Counter
N = int(input())
A = list(map(int, input().split()))

stack = []
cnt = Counter(A)

result = [-1] * N
for i in range(N):
    if not stack:
        stack.append(i)
    else:
        while stack and cnt[A[stack[-1]]] < cnt[A[i]]:
            result[stack.pop()] = A[i]
        stack.append(i)

print(*result)