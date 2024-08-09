N, M = map(int, input().split())

name = {}
number = {}

for i in range(N):
    s = input()
    name[s] = i + 1
    number[i + 1] = s

for _ in range(M):
    s = input()
    if s.isdigit():
        print(number[int(s)])
    else:
        print(name[s])