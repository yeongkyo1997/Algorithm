import sys


def input(): return sys.stdin.readline().strip()


s = input()

cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in cro:
    s = s.replace(i, '1')

print(len(s))