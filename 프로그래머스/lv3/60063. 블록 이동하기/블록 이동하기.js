let map = [];
let n;
let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];
let row = [];
let col = [];
let answer;

function solution(board) {
  n = board.length;
  answer = 0;
  row = Array.from({ length: n }, () => Array.from({ length: n }, () => false));
  col = Array.from({ length: n }, () => Array.from({ length: n }, () => false));
  map = Array.from({ length: n }, () => Array.from({ length: n }, () => 0));
  for (let i = 0; i < n; i++) map[i] = [...board[i]];

  row[0][0] = true;
  row[0][1] = true;

  start();

  return answer;
}

class Queue {
  constructor() {
    this.queue = [];
  }

  enqueue(item) {
    this.queue.push(item);
  }

  dequeue() {
    return this.queue.shift();
  }

  isEmpty() {
    return this.queue.length === 0;
  }
  add(item) {
    this.queue.push(item);
  }

  poll() {
    return this.queue.shift();
  }
}

function start() {
  let q = new Queue();
  q.add(new Robot(new Point(0, 0), new Point(0, 1), 0));
  q.add(new Robot(null, null, -1));
  let count = 0;

  while (!q.isEmpty()) {
    let now = q.poll();

    if (now.dir == -1) {
      count++;
      if (!q.isEmpty()) q.add(new Robot(null, null, -1));
      continue;
    }

    if (
      (now.p1.x == n - 1 && now.p1.y == n - 1) ||
      (now.p2.x == n - 1 && now.p2.y == n - 1)
    ) {
      answer = count;
      break;
    }

    if (now.dir == 0) {
      for (let i = 0; i < 4; i++) {
        let np1X = now.p1.x + dx[i];
        let np1Y = now.p1.y + dy[i];
        let np2X = now.p2.x + dx[i];
        let np2Y = now.p2.y + dy[i];

        if (check(np1X, np1Y) && check(np2X, np2Y)) {
          if (!row[np1X][np1Y] || !row[np2X][np2Y]) {
            let next = new Robot(
              new Point(np1X, np1Y),
              new Point(np2X, np2Y),
              0
            );
            row[np1X][np1Y] = true;
            row[np2X][np2Y] = true;
            q.add(next);
          }
        }
      }

      for (let i = -1; i <= 1; i += 2) {
        let np1X = now.p1.x + i;
        let np1Y = now.p1.y;
        let np2X = now.p2.x + i;
        let np2Y = now.p2.y;

        if (check(np1X, np1Y) && check(np2X, np2Y)) {
          if (
            rotate(np1X, np1Y, now.p1.x, now.p1.y) &&
            (!col[np1X][np1Y] || !col[now.p1.x][now.p1.y])
          ) {
            col[np1X][np1Y] = true;
            col[now.p1.x][now.p1.y] = true;
            q.add(
              new Robot(new Point(np1X, np1Y), new Point(now.p1.x, now.p1.y), 1)
            );
          }
          if (
            rotate(np2X, np2Y, now.p2.x, now.p2.y) &&
            (!col[np2X][np2Y] || !col[now.p2.x][now.p2.y])
          ) {
            col[np2X][np2Y] = true;
            col[now.p2.x][now.p2.y] = true;
            q.add(
              new Robot(new Point(np2X, np2Y), new Point(now.p2.x, now.p2.y), 1)
            );
          }
        }
      }
    } else {
      for (let i = 0; i < 4; i++) {
        let np1X = now.p1.x + dx[i];
        let np1Y = now.p1.y + dy[i];
        let np2X = now.p2.x + dx[i];
        let np2Y = now.p2.y + dy[i];

        if (check(np1X, np1Y) && check(np2X, np2Y)) {
          if (!col[np1X][np1Y] || !col[np2X][np2Y]) {
            let next = new Robot(
              new Point(np1X, np1Y),
              new Point(np2X, np2Y),
              1
            );
            col[np1X][np1Y] = true;
            col[np2X][np2Y] = true;
            q.add(next);
          }
        }
      }

      for (let i = -1; i <= 1; i += 2) {
        let np1X = now.p1.x;
        let np1Y = now.p1.y + i;
        let np2X = now.p2.x;
        let np2Y = now.p2.y + i;

        if (check(np1X, np1Y) && check(np2X, np2Y)) {
          if (
            rotate(np1X, np1Y, now.p1.x, now.p1.y) &&
            (!row[np1X][np1Y] || !row[now.p1.x][now.p1.y])
          ) {
            row[np1X][np1Y] = true;
            row[now.p1.x][now.p1.y] = true;
            q.add(
              new Robot(new Point(np1X, np1Y), new Point(now.p1.x, now.p1.y), 0)
            );
          }
          if (
            rotate(np2X, np2Y, now.p2.x, now.p2.y) &&
            (!row[np2X][np2Y] || !row[now.p2.x][now.p2.y])
          ) {
            row[np2X][np2Y] = true;
            row[now.p2.x][now.p2.y] = true;
            q.add(
              new Robot(new Point(np2X, np2Y), new Point(now.p2.x, now.p2.y), 0)
            );
          }
        }
      }
    }
  }
}

function rotate(x1, y1, x2, y2) {
  if (!check(x1, y1) || !check(x2, y2)) return false;

  return true;
}

function check(x, y) {
  return x >= 0 && y >= 0 && x < n && y < n && map[x][y] == 0;
}

class Robot {
  constructor(p1, p2, dir) {
    this.p1 = p1;
    this.p2 = p2;
    this.dir = dir;
  }
}

class Point {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}
