arr = map(int, input().split())
s = sum(map(lambda x: x ** 2, arr))

print(str(s)[-1])