def solution(s):
    result = 0
    idx = 0

    while idx < len(s):
        char = s[idx]
        char_cnt = 0
        other_cnt = 0

        for i in range(idx, len(s)):
            if s[i] == char:
                char_cnt += 1
            else:
                other_cnt += 1

            if char_cnt == other_cnt:
                result += 1
                idx = i + 1
                break
        else:
            if char_cnt != other_cnt:
                result += 1
            break

    return result
