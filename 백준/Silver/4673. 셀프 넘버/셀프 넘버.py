def d(n):
    return n + sum(map(int, str(n)))


exist = [False] * 10001

for i in range(1, 10001):
    if d(i) <= 10000:
        exist[d(i)] = True

for i in range(1, 10001):
    if not exist[i]:
        print(i)