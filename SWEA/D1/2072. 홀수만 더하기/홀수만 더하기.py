T = int(input())

for t in range(1, T + 1):
    arr = list(map(int, input().rstrip().split()))
    result = sum(i for i in arr if i % 2 != 0)

    print(f'#{t} {result}')