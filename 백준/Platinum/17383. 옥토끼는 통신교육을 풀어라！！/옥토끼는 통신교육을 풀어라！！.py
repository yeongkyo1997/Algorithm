import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
maxValue = arr[-1]


def getMinimumTaskTime():
    MIN = 1
    MAX = maxValue
    ret = MAX
    while MIN <= MAX:
        taskTime = (MIN + MAX) // 2
        if doTask(taskTime):
            MAX = taskTime - 1
            ret = taskTime
        else:
            MIN = taskTime + 1
    return ret


def doTask(taskTime):
    if arr[0] > taskTime:
        return False
    prime = 0
    1
    for i in range(1, N):
        if arr[i] <= taskTime * 1:
            prime += 1
            continue

        space = arr[i] // taskTime + (1 if arr[i] % taskTime > 0 else 0) - 2
        if space > prime:
            return False
        prime -= space
    return True


print(getMinimumTaskTime())