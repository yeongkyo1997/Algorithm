n = int(input())

cnt = 0
tmp = n

while True:
    cnt += 1
    sum_ = (tmp // 10) + (tmp % 10)
    tmp = (tmp % 10) * 10 + (sum_ % 10)
    if tmp == n:
        break

print(cnt)