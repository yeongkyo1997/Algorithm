import sys
sys.setrecursionlimit(10**6)
def solution(k, num, links):
    parents = [-1] * len(num)

    for i in range(len(links)):
        if links[i][0] != -1:
            parents[links[i][0]] = i
        if links[i][1] != -1:
            parents[links[i][1]] = i

    root = -1
    for i in range(len(parents)):
        if parents[i] == -1:
            root = i
            break

    min_value = max(num)
    max_value = 100000000

    while min_value <= max_value:
        mid = (min_value + max_value) // 2

        if can_make(k, num, links, root, mid):
            max_value = mid - 1
        else:
            min_value = mid + 1

    return min_value

def can_make(k, num, links, root, mid):
    count = [0]
    dfs(num, links, root, mid, count)
    return count[0] < k

def dfs(num, links, curr, mid, count):
    left = 0
    right = 0
    if links[curr][0] != -1:
        left = dfs(num, links, links[curr][0], mid, count)
    if links[curr][1] != -1:
        right = dfs(num, links, links[curr][1], mid, count)

    if num[curr] + left + right <= mid:
        return num[curr] + left + right

    if num[curr] + min(left, right) <= mid:
        count[0] += 1
        return num[curr] + min(left, right)

    count[0] += 2
    return num[curr]
