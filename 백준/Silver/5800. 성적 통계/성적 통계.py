import sys

class_num = int(sys.stdin.readline().rstrip())

for i in range(class_num):
    class_info = list(map(int, sys.stdin.readline().rstrip().split()))
    student_num = class_info[0]
    scores = sorted(class_info[1:], reverse=True)
    max_score, min_score = max(scores), min(scores)
    largest_gap = 0
    for j in range(1, student_num):
        gap = scores[j-1] - scores[j]
        if gap > largest_gap:
            largest_gap = gap
    print(f"Class {i+1}")
    print(f"Max {max_score}, Min {min_score}, Largest gap {largest_gap}")