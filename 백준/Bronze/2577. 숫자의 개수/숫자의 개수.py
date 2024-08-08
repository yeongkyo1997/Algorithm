import collections

A = int(input())
B = int(input())
C = int(input())

cnt = collections.Counter(str(A * B * C))

for i in range(10):
    print(cnt[str(i)])