import copy


def solution(clockHands):
    size = len(clockHands)
    minVal = 10 ** 9

    choice = [0] * size
    maxSize = 4 ** size

    for i in range(maxSize):
        count = solveCount(size, choice, clockHands);
        if count < minVal:
            minVal = count
        nextChoice(choice)

    return minVal


def nextChoice(choice):
    for i in range(len(choice)):
        choice[i] += 1
        if choice[i] == 4:
            choice[i] = 0
        else:
            break


def complement(size, out, row):
    for i in range(size):
        out[i] = (4 - row[i]) % 4


def solveCount(size, firstChoice, puzzle):
    count = 0

    prevChoice = [0] * size
    curRow = [0] * size

    curChoice = copy.deepcopy(firstChoice)

    for i in range(size):
        for choice in curChoice:
            count += choice
        calcRow(size, curRow, puzzle[i], prevChoice, curChoice)

        tmp = prevChoice
        prevChoice = curChoice
        curChoice = tmp

        complement(size, curChoice, curRow)
    for elem in curRow:
        if elem != 0:
            return 10 ** 9
    return count


def calcRow(size, out, row, prevChoice, curChoice):
    endIdx = size - 1
    out[0] = (row[0] + prevChoice[0] + curChoice[0] + curChoice[1]) % 4

    for i in range(1, endIdx):
        out[i] = (row[i] + prevChoice[i] + curChoice[i - 1] + curChoice[i] + curChoice[i + 1]) % 4
    out[endIdx] = (row[endIdx] + prevChoice[endIdx] + curChoice[endIdx - 1] + curChoice[endIdx]) % 4


def calcNextChoice(row, choice):
    size = len(row)
    next = [0] * size

    for i in range(size):
        next[i] = (8 - row[i] - choice[i]) % 4
    return next

