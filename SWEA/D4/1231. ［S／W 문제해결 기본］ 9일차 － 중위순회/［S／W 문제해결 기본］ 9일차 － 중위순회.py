import collections


def inorder(root):
    global result
    if root == -1:
        return
    inorder(tree[root][1])
    result += tree[root][0]
    inorder(tree[root][2])


results = []
for t in range(1, 11):
    N = int(input())
    tree = collections.defaultdict()

    for i in range(N):
        arr = input().split()

        if len(arr) == 4:
            num, alpha, left, right = arr
            num, left, right = map(int, (num, left, right))
            tree[num] = (alpha, left, right)
        elif len(arr) == 3:
            num, alpha, left = arr
            num, left = map(int, (num, left))
            tree[num] = (alpha, left, -1)
        elif len(arr) == 2:
            num, alpha = arr
            num = int(num)
            tree[num] = (alpha, -1, -1)
    result = ''
    inorder(1)
    results.append(f'#{t} {result}')

print(*results, sep='\n')
