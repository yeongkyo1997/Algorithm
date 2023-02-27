import collections

alpha = input()
dict = collections.defaultdict(lambda: -1)

for i in range(ord('a'), ord('z') + 1):
    dict[i] = alpha.find(chr(i))

print(*dict.values())