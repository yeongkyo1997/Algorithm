function solution(distance, rocks, n) {
  rocks = rocks.sort((a, b) => a - b);
  let subDistances = Array.from({ length: rocks.length + 1 }, () => 0);
  subDistances[0] = rocks[0];
  subDistances[rocks.length] = distance - rocks[rocks.length - 1];
  for (let i = 1; i < rocks.length; i++)
    subDistances[i] = rocks[i] - rocks[i - 1];
  let left = 1;
  let right = distance;
  let mid = Math.floor((left + right) / 2);
  let current, removed;
  while (right - left > 1) {
    removed = 0;
    current = 0;
    for (let i = 0; i < subDistances.length; i++) {
      current += subDistances[i];
      if (current < mid) removed++;
      else current = 0;
    }
    if (removed > n) right = mid;
    else left = mid;
    mid = Math.floor((left + right) / 2);
  }
  return mid;
}
