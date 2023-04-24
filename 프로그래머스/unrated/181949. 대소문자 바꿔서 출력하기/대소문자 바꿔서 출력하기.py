str = input()

for i in list(str):
    if i.isupper():
        print(i.lower(), end='')
    else:
        print(i.upper(), end='')