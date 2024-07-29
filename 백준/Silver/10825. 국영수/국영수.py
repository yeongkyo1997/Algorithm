N = int(input())

arr = []
for _ in range(N):
    st = input().split()
    name = st[0]
    kor, eng, math = map(int, st[1:])
    arr.append((name, kor, eng, math))

arr.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for a in arr:
    print(a[0])