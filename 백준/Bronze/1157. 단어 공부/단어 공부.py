import collections

arr = list(input())
arr = map(lambda x: x.upper(), arr)

dict = collections.defaultdict(lambda: 0)

for i in arr:
    dict[i] += 1

sorted_dict = sorted(dict.items(), key=lambda x: -x[1])

if len(sorted_dict) > 1 and sorted_dict[0][1] == sorted_dict[1][1]:
    print('?')
else:
    print(sorted_dict[0][0])