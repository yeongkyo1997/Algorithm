import sys

input = lambda: sys.stdin.readline().rstrip()

map = [[0] * 3 for _ in range(3)]
string = input()

while string != 'end':
    onum = 0
    xnum = 0
    owin = False
    xwin = False

    for i in range(9):
        map[i // 3][i % 3] = string[i]
        if string[i] == 'O':
            onum += 1
        elif string[i] == 'X':
            xnum += 1

    for j in range(3):
        if map[0][j] == 'O' and map[0][j] == map[1][j] and map[1][j] == map[2][j]:
            owin = True
            break
    for i in range(3):
        if map[i][0] == 'O' and map[i][0] == map[i][1] and map[i][1] == map[i][2]:
            owin = True
            break

    if map[0][0] == 'O' and map[0][0] == map[1][1] and map[1][1] == map[2][2]:
        owin = True

    if map[0][2] == 'O' and map[0][2] == map[1][1] and map[1][1] == map[2][0]:
        owin = True

    for j in range(3):
        if map[0][j] == 'X' and map[0][j] == map[1][j] and map[1][j] == map[2][j]:
            xwin = True
            break
    for i in range(3):
        if map[i][0] == 'X' and map[i][0] == map[i][1] and map[i][1] == map[i][2]:
            xwin = True
            break

    if map[0][0] == 'X' and map[0][0] == map[1][1] and map[1][1] == map[2][2]:
        xwin = True

    if map[0][2] == 'X' and map[0][2] == map[1][1] and map[1][1] == map[2][0]:
        xwin = True

    if (xwin and not owin and xnum - onum == 1) or (not xwin and owin and onum == xnum) or (
            not xwin and not owin and xnum == 5 and onum == 4):
        print('valid')
    else:
        print('invalid')

    string = input()
