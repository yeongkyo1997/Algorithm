let adj = [];
let visit = [];
let depth = 0;

function solution(n, edge) {
  let answer = 0;
  visit = Array.from({ length: n + 1 }, () => 0);
  adj = Array.from({ length: n + 1 }, () => 0);
  for (let i = 1; i <= n; i++) adj[i] = [];
  for (let i = 0; i < edge.length; i++) {
    adj[edge[i][0]].push(edge[i][1]);
    adj[edge[i][1]].push(edge[i][0]);
  }

  bfs(1, 1);

  for (let i = 1; i <= n; i++) {
    if (depth == visit[i]) answer += 1;
  }

  return answer;
}

class Queue {
  constructor() {
    this.queue = [];
  }
  enqueue(data) {
    this.queue.push(data);
  }
  dequeue() {
    return this.queue.shift();
  }
  isEmpty() {
    return this.queue.length == 0;
  }

  push(data) {
    this.queue.push(data);
  }
  poll() {
    return this.queue.shift();
  }
}

function bfs(start, count) {
  let q = new Queue();
  q.push(start);
  q.push(count);
  visit[start] = count;

  while (!q.isEmpty()) {
    let node = q.poll();
    let n = q.poll();

    if (depth < n) depth = n;
    for (let i = 0; i < adj[node].length; i++) {
      let next = adj[node][i];

      if (visit[next] != 0) continue;
      visit[next] = n + 1;
      q.push(next);
      q.push(n + 1);
    }
  }
}
