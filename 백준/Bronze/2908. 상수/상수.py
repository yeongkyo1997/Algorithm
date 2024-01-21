a, b = input().split()
print(max(int(str(a)[::-1]), int(str(b)[::-1])))