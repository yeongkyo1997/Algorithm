function solution(land, height) {
    const N = land.length;
    const moves = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    const q = [];
    const areas = [...Array(N)].map(_ => [...Array(N)].map(_ => 0));
    let area = 1;

    const is_out_of_range = (y, x) => (y < 0 || y >= N || x < 0 || x >= N);

    // 1. bfs를 통해 서로 이동할 수 있는 영역 나누기 (1번 계획)
    land.forEach((row, y) => {
        row.forEach((cur_height, x) => {
            if (!areas[y][x]) {
                q.push([y, x]);
                areas[y][x] = area;

                while (q.length) {
                    const [y, x] = q.shift();

                    for (const [my, mx] of moves) {
                        const ny = y + my;
                        const nx = x + mx;

                        // 영역 밖일 때
                        if (is_out_of_range(ny, nx)) continue;

                        // 지금 칠하고 있는 영역일 때
                        if (areas[ny][nx]) continue;

                        // 칠하고자 하는 칸과 현재 있는 칸 차이가 height보다 클 때
                        if (Math.abs(land[y][x] - land[ny][nx]) > height) continue;

                        q.push([ny, nx]);
                        areas[ny][nx] = area;
                    }
                }

                area++;
            }
        });
    });

    /**
     *  크루스칼 알고리즘 구현에 필요한 리스트와 union-find 함수들
     */
    const set = [...Array(area)].map((_, i) => i);

    const find = a => (set[a] = set[a] == a ? a : find(set[a]));

    const union = (a, b) => {
        a = find(a);
        b = find(b);

        a > b ? set[a] = b : set[b] = a;
    };

    const is_same_parent = (a, b) => (find(a) == find(b));

    return (
        areas
            // 2. 영역과 영역 사이에 설치할 수 있는 사다리들을 담는다. (2번 계획)
            .reduce((m, row, y) => {
                return row.reduce((m, area, x) => {
                    for (const [my, mx] of moves) {
                        const ny = y + my;
                        const nx = x + mx;

                        // 영역 밖일 때
                        if (is_out_of_range(ny, nx)) continue;

                        // 같은 영역일 때
                        if (area == areas[ny][nx]) continue;

                        // 사다리를 담아준다. [설치 비용, 영역1, 영역2]
                        m.push([Math.abs(land[y][x] - land[ny][nx]), area, areas[ny][nx]]);
                    }

                    return m;
                }, m);
            }, [])
            // 3. 크루스칼 알고리즘으로 최소 비용 리턴 (3번 계획)
            .sort(([a], [b]) => a - b) // 설치 비용을 오름차순으로 정렬
            .reduce((m, [cost, a, b]) => {
                // 부모 노드가 같을 때
                if (is_same_parent(a, b)) return m;

                // 정점 이어주기
                union(a, b);

                // 설치 비용 누적
                return m += cost;
            }, 0)
    );
}