import sys
input = sys.stdin.readline

n = int(input())
used = set()
out = []
for _ in range(n):
    s = input().rstrip('\n')
    pos = -1
    for j, c in enumerate(s):
        if c != ' ' and (j == 0 or s[j-1] == ' ') and c.lower() not in used:
            pos = j
            break
    if pos < 0:
        for j, c in enumerate(s):
            if c != ' ' and c.lower() not in used:
                pos = j
                break
    if pos >= 0:
        used.add(s[pos].lower())
        s = s[:pos] + '[' + s[pos] + ']' + s[pos+1:]
    out.append(s)
print('\n'.join(out))
