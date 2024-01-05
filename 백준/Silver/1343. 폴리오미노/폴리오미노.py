import sys
import re


def input(): return sys.stdin.readline().strip()


s = input()

sp = re.findall(r'[X]+|\.+', s)
result = ''
for i in sp:
    if i[0] == 'X':
        if len(i) % 2 == 0:
            result += f'{"A" * 4}' * (len(i) // 4) + \
                f'{"B" * 2}' * ((len(i) % 4) // 2)
        else:
            result = -1
            break
    else:
        result += i

print(result)