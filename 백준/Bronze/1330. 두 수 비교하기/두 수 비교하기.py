a, b = map(int, input().rstrip().split())
if a > b:
    print('>')
elif a < b:
    print('<')
else:
    print('==')