import sys

input = lambda: sys.stdin.readline().rstrip()
total = int(input().strip())
difference = int(input().strip())

natalia = (total - difference) // 2

klaudia = natalia + difference

print(klaudia)
print(natalia)