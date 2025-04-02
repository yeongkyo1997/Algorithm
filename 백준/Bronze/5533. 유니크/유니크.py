import sys
from collections import Counter


n = int(sys.stdin.readline())


submissions = []
for _ in range(n):
    submissions.append(list(map(int, sys.stdin.readline().split())))


total_scores = [0] * n


for round_index in range(3):

    current_round_submissions = []
    for player_index in range(n):
        current_round_submissions.append(submissions[player_index][round_index])

    round_counts = Counter(current_round_submissions)

    for player_index in range(n):

        submitted_score = submissions[player_index][round_index]

        if round_counts[submitted_score] == 1:

            total_scores[player_index] += submitted_score


for score in total_scores:
    print(score)
