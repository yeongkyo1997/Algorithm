n = int(input())
if n == 0:
    print(0)
    exit(0)

result = ""
while n:
    q, r = divmod(n, -2)
    n = q
    if r < 0:
        r += 2
        n += 1
    result = str(r) + result

print(result)