import sys

input = lambda: sys.stdin.readline().rstrip()

S = input().replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6",
                                                                                                         "").replace(
    "7", "").replace("8", "").replace("9", "").replace("0", "")
word = input()

if word in S:
    print(1)
else:
    print(0)