from collections import Counter

N = int(input())
card1 = Counter(map(int, input().split()))
M = int(input())
card2 = list(map(int, input().split()))

for i in card2:
    print(card1[i], end=' ')