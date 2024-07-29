K = int(input())

choco, split = 1, 0

while choco < K:
    choco *= 2

print(choco, end=' ')

while K > 0:
    if K >= choco:
        K -= choco
    else:
        choco //= 2
        split += 1


print(split)