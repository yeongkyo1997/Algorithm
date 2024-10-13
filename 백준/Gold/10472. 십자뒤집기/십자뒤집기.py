from collections import deque

if __name__ == "__main__":
    P = int(input())
    index = 1

    # 3x3 보드의 각 셀에 대한 토글 마스크 미리 계산
    toggle_masks = []
    for i in range(9):
        mask = 1 << i  # 자신
        row, col = divmod(i, 3)
        # 상
        if row > 0:
            mask |= 1 << (i - 3)
        # 하
        if row < 2:
            mask |= 1 << (i + 3)
        # 좌
        if col > 0:
            mask |= 1 << (i - 1)
        # 우
        if col < 2:
            mask |= 1 << (i + 1)
        toggle_masks.append(mask)

    for _ in range(P):
        # 각 테스트 케이스의 보드 읽기
        board = [input() for _ in range(3)]

        # 목표 상태를 비트마스크로 변환
        target = 0
        for r in range(3):
            for c in range(3):
                if board[r][c] == '*':
                    bit = r * 3 + c
                    target |= 1 << bit

        # BFS 초기화
        visited = [-1] * 512  # 2^9 = 512 가능한 상태
        queue = deque()

        start = 0  # 모든 칸이 흰색인 상태
        visited[start] = 0
        queue.append(start)

        while queue:
            current = queue.popleft()
            current_steps = visited[current]

            if current == target:
                print(current_steps)
                break

            for i in range(9):
                next_state = current ^ toggle_masks[i]
                if visited[next_state] == -1:
                    visited[next_state] = current_steps + 1
                    queue.append(next_state)
        else:
            print(-1)
