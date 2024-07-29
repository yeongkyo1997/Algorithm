def create_title_and_check_usage(poem, space_bar_limit, key_limits):
    # 시의 제목을 만들기 위해 첫 글자를 대문자로 변환
    words = poem.split()
    title = ''.join(word[0].upper() for word in words)

    # 사용 횟수 초기화
    space_bar_used = 0
    key_used = [0] * 26

    # 시의 내용을 기록하기 위한 사용 횟수 계산
    prev_char = ''
    for char in poem:
        if char == ' ':
            if prev_char != ' ':
                space_bar_used += 1
        else:
            index = ord(char.lower()) - ord('a')
            if prev_char.lower() != char.lower():
                key_used[index] += 1
        prev_char = char

    # 시의 제목을 기록하기 위한 사용 횟수 계산
    for char in title:
        index = ord(char.lower()) - ord('a')
        key_used[index] += 1

    # 사용 횟수 초과 여부 확인
    if space_bar_used > space_bar_limit:
        return -1

    for i in range(26):
        if key_used[i] > key_limits[i]:
            return -1

    return title


poem = input().strip()
space_bar_limit = int(input().strip())
key_limits = list(map(int, input().strip().split()))

result = create_title_and_check_usage(poem, space_bar_limit, key_limits)
print(result)