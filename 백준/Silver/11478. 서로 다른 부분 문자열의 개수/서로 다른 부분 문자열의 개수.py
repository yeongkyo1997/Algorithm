s = input()


result = set()
for i in range(len(s)):
    for j in range(len(s) + 1):
        result.add(s[i:j])
print(len(result) - 1)