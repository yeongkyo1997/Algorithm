N = int(input())

for i in range(1, N + 1):
    if i + sum(map(int, str(i))) == N:
        print(i)
        break
else:
    print(0)