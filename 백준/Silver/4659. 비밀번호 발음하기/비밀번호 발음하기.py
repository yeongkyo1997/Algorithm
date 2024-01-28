import sys
import re


def input(): return sys.stdin.readline().rstrip()


vowel = 'aeiou'


def check(password):
    if not re.search(r'(?=[aeiou])', password):
        return False
    if re.search(r'(?=[aeiou]{3,})', password):
        return False
    if re.search(r'(?=[^aeiou]{3,})', password):
        return False
    if re.search(r'(?=([^oe])\1)', password):
        return False
    return True


while True:
    password = input()
    if password == 'end':
        break
    if check(password):
        print(fr'<{password}> is acceptable.')
    else:
        print(fr'<{password}> is not acceptable.')