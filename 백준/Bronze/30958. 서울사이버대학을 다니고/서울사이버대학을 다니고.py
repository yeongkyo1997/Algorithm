import sys
from collections import Counter


n = int(sys.stdin.readline())


logo_song = sys.stdin.readline().strip()


alphabet_counts = Counter()


for char in logo_song:

    if "a" <= char <= "z":

        alphabet_counts[char] += 1


max_frequency = 0
if alphabet_counts:

    max_frequency = max(alphabet_counts.values())


print(max_frequency)
