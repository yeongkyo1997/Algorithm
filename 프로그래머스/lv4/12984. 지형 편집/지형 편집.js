function solution(land, P, Q) {
  let y, x, heigth;
  let height = land.length;
  let width = land[0].length;

  let s = 1000000000;
  let e = 0;
  for (y = 0; y < height; y++) {
    for (x = 0; x < width; x++) {
      e = Math.max(e, land[y][x]);
      s = Math.min(s, land[y][x]);
    }
  }

  let mid = 0;

  while (s <= e) {
    mid = parseInt((s + e) / 2);
    if (s == e) {
      break;
    }

    let r1 = getCost(mid, land, P, Q);
    let r2 = getCost(mid + 1, land, P, Q);
    if (r1 == r2) {
      break;
    }
    if (r1 < r2) {
      e = mid;
    } else {
      s = mid + 1;
    }
  }
  return getCost(mid, land, P, Q);
}

function getCost(mid, land, P, Q) {
  let result = 0;
  for (let i = 0; i < land.length; i++) {
    for (let j = 0; j < land[0].length; j++) {
      if (land[i][j] > mid) {
        result = result + (land[i][j] - mid) * Q;
      } else if (land[i][j] < mid) {
        result = result + (mid - land[i][j]) * P;
      }
    }
  }
  return result;
}
