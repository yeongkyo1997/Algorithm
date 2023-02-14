function solution(lines) {
  let answer = 0;
  let startTimes = Array.from({ length: lines.length }, () => 0);
  let endTimes = Array.from({ length: lines.length }, () => 0);

  for (let i = 0; i < lines.length; ++i) {
    let log = lines[i].split(" ");
    let responseTime = log[1].split(":");
    let processingTime = Math.floor(
      Number(log[2].substring(0, log[2].length - 1)) * 1000
    );
    let startTime = 0;
    let endTime = 0;

    endTime += Math.floor(Number(responseTime[0])) * 60 * 60 * 1000;
    endTime += Math.floor(Number(responseTime[1])) * 60 * 1000;
    endTime += Math.floor(Number(responseTime[2]) * 1000);
    startTime = endTime - processingTime + 1;

    startTimes[i] = startTime;
    endTimes[i] = endTime;
  }

  for (let i = 0; i < lines.length; ++i) {
    let cnt = 0;
    let startOfSection = startTimes[i];
    let endOfSection = startOfSection + 1000;

    for (let j = 0; j < lines.length; ++j) {
      if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
        cnt++;
      } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
        cnt++;
      } else if (
        startTimes[j] <= startOfSection &&
        endTimes[j] >= endOfSection
      ) {
        cnt++;
      }
    }

    answer = cnt > answer ? cnt : answer;
  }

  for (let i = 0; i < lines.length; ++i) {
    let cnt = 0;
    let startOfSection = endTimes[i];
    let endOfSection = startOfSection + 1000;

    for (let j = 0; j < lines.length; ++j) {
      if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
        cnt++;
      } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection)
        cnt++;
      else if (
        startTimes[j] <= startOfSection &&
        endTimes[j] >= endOfSection
      ) {
        cnt++;
      }
    }

    answer = cnt > answer ? cnt : answer;
  }

  return answer;
}