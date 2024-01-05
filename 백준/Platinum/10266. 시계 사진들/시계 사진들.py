import sys
def input(): return sys.stdin.readline().rstrip()


def kmp_table(pattern):
    table = [0] * len(pattern)
    j = 0

    for i in range(1, len(pattern)):
        if pattern[i] == pattern[j]:
            j += 1
            table[i] = j
        else:
            if j != 0:
                j = table[j - 1]
                i -= 1
            else:
                table[i] = 0
    return table


def kmp_search(text, pattern):
    table = kmp_table(pattern)
    i = j = 0

    while i < len(text):
        if text[i] == pattern[j]:
            i += 1
            j += 1

            if j == len(pattern):
                return True
        else:
            if j != 0:
                j = table[j - 1]
            else:
                i += 1
    return False


def normalize_clock_angles(clock):
    clock.sort()
    min_angle = clock[0]
    return [(angle - min_angle) % 360000 for angle in clock]


def is_same_time(clock1, clock2):
    normalized_clock1 = normalize_clock_angles(clock1)
    normalized_clock2 = normalize_clock_angles(clock2)

    extended_clock = normalized_clock1 + normalized_clock1

    return kmp_search(extended_clock, normalized_clock2)


def angle_differences(clock):
    clock.sort()
    differences = []
    for i in range(len(clock)):
        next_index = (i + 1) % len(clock)
        difference = (clock[next_index] - clock[i]) % 360000
        differences.append(difference)
    return differences


def solve(clock1, clock2):
    diff1 = angle_differences(clock1)
    diff2 = angle_differences(clock2)

    extended_diff1 = diff1 + diff1
    return kmp_search(extended_diff1, diff2)


n = int(input())
clock1 = list(map(int, input().split()))
clock2 = list(map(int, input().split()))


print('possible' if solve(clock1, clock2) else 'impossible')