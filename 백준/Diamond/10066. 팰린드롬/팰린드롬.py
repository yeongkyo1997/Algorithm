if __name__ == '__main__':
    s = input()
    n = len(s)

    len_nodes = [-1, 0]
    link = [0, 0]
    next_nodes = [{} for _ in range(2)]
    cnt = [0, 0]

    cur = 1
    total_nodes = 2

    for i in range(n):
        c = ord(s[i]) - ord('a')
        tmp = cur
        while True:
            l = len_nodes[tmp]
            if i - l - 1 >= 0 and s[i - l - 1] == s[i]:
                break
            tmp = link[tmp]
        if c in next_nodes[tmp]:
            cur = next_nodes[tmp][c]
            cnt[cur] += 1
        else:
            len_nodes.append(len_nodes[tmp] + 2)
            link.append(0)
            next_nodes.append({})
            cnt.append(1)
            new_node = total_nodes
            next_nodes[tmp][c] = new_node
            if len_nodes[new_node] == 1:
                link[new_node] = 1
            else:
                temp_link = link[tmp]
                while True:
                    l = len_nodes[temp_link]
                    if i - l - 1 >= 0 and s[i - l - 1] == s[i]:
                        link[new_node] = next_nodes[temp_link][c]
                        break
                    temp_link = link[temp_link]
            cur = new_node
            total_nodes += 1

    nodes_order = sorted(range(total_nodes), key=lambda x: len_nodes[x], reverse=True)
    for node in nodes_order:
        if link[node] != node and link[node] >= 0:
            cnt[link[node]] += cnt[node]

    max_val = 0
    for node in range(2, total_nodes):
        val = cnt[node] * len_nodes[node]
        if val > max_val:
            max_val = val
    for node in range(0, 2):
        val = cnt[node] * len_nodes[node]
        if val > max_val:
            max_val = val
    print(max_val)