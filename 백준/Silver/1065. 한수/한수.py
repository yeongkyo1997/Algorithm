import sys


def input(): return sys.stdin.readline().strip()


N = int(input())
count = 0

for num in range(1, N + 1):
    num_str = str(num)
    if len(num_str) <= 2:
        count += 1
    else:
        is_hansu = True
        diff = int(num_str[1]) - int(num_str[0])
        for i in range(2, len(num_str)):
            if int(num_str[i]) - int(num_str[i - 1]) != diff:
                is_hansu = False
                break
        if is_hansu:
            count += 1

print(count)