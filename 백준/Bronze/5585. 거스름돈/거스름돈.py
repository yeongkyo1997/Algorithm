N = int(input())
remain = 1000 - N
money = [500, 100, 50, 10, 5, 1]
result = 0

while remain:
    for i in money:
        if remain >= i:
            remain -= i
            result += 1
            break
print(result)
