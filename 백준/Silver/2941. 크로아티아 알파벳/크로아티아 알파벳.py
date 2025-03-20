import sys
import re

input = lambda: sys.stdin.readline().rstrip()

count = {}

word = input()
word = re.sub(r"c=|c-|dz=|d-|lj|nj|s=|z=", "1", word)

print(len(word))
