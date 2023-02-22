def solution(n, start, end, roads, traps):
    arr = [[] for _ in range(n + 1)]
    for a, b, c in roads:
        arr[a].append([b, c])
        arr[b].append([a, -c])

    tMap = {traps[i]: i for i in range(len(traps))}

    def isTrap(node):
        return node in tMap

    def triggered(bits, node):
        return 0 if not isTrap(node) or (bits & (1 << tMap.get(node))) == 0 else 1

    visited = [set() for _ in range(n + 1)]
    pq = [[0, start, 0]]
    while len(pq):
        pq.sort(reverse=True)

        cost, cur, bits = pq.pop()

        if cur == end:
            return cost

        if bits in visited[cur]:
            continue

        visited[cur].add(bits)
        curTrigger = triggered(bits, cur)

        for nxt, c in arr[cur]:
            dir = 1 if c < 0 else 0
            reverse = (dir + curTrigger + triggered(bits, nxt)) % 2
            if reverse:
                continue
            pq.append([cost + (c if c > 0 else -c), nxt, bits ^ (1 << tMap.get(nxt)) if isTrap(nxt) else bits]);
