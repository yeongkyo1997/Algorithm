import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()


def greedy(n, question):
    ret = question[0][0]
    heap = []

    for i in range(1, n // 2):
        heapq.heappush(heap, -question[2 * i - 1][0])
        heapq.heappush(heap, -question[2 * i][0])

        top = -heapq.heappop(heap)
        ret += top

    return ret


def main():
    n = int(input())

    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    question = [(A[i], B[i]) for i in range(n)]

    question.sort(key=lambda x: x[1])

    result = greedy(n, question)
    print(result)


if __name__ == "__main__":
    main()