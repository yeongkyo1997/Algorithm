import sys


def input(): return sys.stdin.readline().rstrip()


grades = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0,
          'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}

result = []
scores = []
for _ in range(20):
    _, score, grade = input().split()

    if grade == 'P':
        continue
    scores.append(float(score))

    result.append(float(score) * grades[grade])

print(sum(result) / sum(scores))