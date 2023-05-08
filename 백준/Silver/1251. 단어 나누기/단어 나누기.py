import sys

input = lambda: sys.stdin.readline().rstrip()

words = input()
result = ''
for i in range(1, len(words) - 1):
    for j in range(i + 1, len(words)):
        word1 = words[:i][::-1]
        word2 = words[i:j][::-1]
        word3 = words[j:][::-1]
        result = min(result, word1 + word2 + word3) if result else word1 + word2 + word3
print(result)