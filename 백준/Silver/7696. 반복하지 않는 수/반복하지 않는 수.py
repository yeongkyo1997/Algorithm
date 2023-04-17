import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

arr = []
visited = [False] * 10
string = ''

def recur(depth, size):
    global string
    if depth == size:
        arr.append(string)
        return
    
    for i in range(10):
        if len(arr) == 1000001:
            break
        if visited[i]:
            continue
        
        if len(string) != 0 and string[0] == '0':
            continue
        
        visited[i] = True
        string += str(i)
        recur(depth + 1, size)
        string = string[:-1]
        visited[i] = False

for i in range(1, 9):
    recur(0, i)

while True:
    n = int(input())
    if n == 0:
        break
    print(arr[n])