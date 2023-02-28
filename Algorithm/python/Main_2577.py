import collections

a = int(input())
b = int(input())
c = int(input())

dict = collections.defaultdict(lambda: 0)

for i in list(str(a * b * c)):
    dict[int(i)] += 1

for i in range(10):
    print(dict[i])
