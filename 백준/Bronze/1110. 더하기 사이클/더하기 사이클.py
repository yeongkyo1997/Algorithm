import sys

n = int(sys.stdin.readline())

cycle = 0

def new_num(x):
    if x < 10:
        x = '0' + str(x)
    else:
        x = str(x)
    s = int(x[0]) + int(x[1])
    return int(x[1] + str(s)[-1])

temp = n
while True:
    cycle += 1
    temp = new_num(temp)
    if temp == n:
        break

print(cycle)