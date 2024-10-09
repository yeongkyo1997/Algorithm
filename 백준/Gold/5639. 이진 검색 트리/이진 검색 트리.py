import heapq
import sys

sys.setrecursionlimit(10 ** 5)
"""
아이디어:
전위 순회는 재귀 탐색을 할 때 루트 노드, 왼쪽, 오른쪽 순서대로 한다
결과적으로 배열에서 가장 오른쪽이 루트, 루트노드보다 작은 값은 왼쪽, 루트노드보다 큰 값은 오른쪽 -> 재귀적으로 반복한다 
"""


# 역추적하는 함수
def make_tree(arr):
    if not arr:
        return

    # 왼쪽, 오른쪽 서브트리를 구한다
    left = []
    right = []

    mid = arr[0]
    for i in range(1, len(arr)):
        if arr[i] > mid:
            left = arr[1:i]
            right = arr[i:]
            break
    else:
        left = arr[1:]

    make_tree(left)
    make_tree(right)
    print(mid)


if __name__ == '__main__':
    arr = []
    while True:
        try:
            val = int(input())
            arr.append(val)
        except:
            break
    make_tree(arr)