import sys

input = lambda: sys.stdin.readline().rstrip()

n = input()
result = 0
num = ''
isMinus = False

for i in range(len(n) + 1):
    if i == len(n):
        if isMinus:
            result -= int(num)
            num = ''
        else:
            result += int(num)
            num = ''
    elif n[i] == '-' or n[i] == '+':
        if isMinus:
            result -= int(num)
            num = ''
        else:
            result += int(num)
            num = ''
        if n[i] == '-':
            isMinus = True
    else:
        num += n[i]
print(result)
