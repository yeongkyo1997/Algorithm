function solution(m, musicinfos) {
  let maxPlayTime = -1;
  let answer = "";

  m = changeMelody(m);

  for (let musicInfo of musicinfos) {
    let info = musicInfo.split(",");
    let title = info[2];
    let melodyInfo = changeMelody(info[3]);

    let timeInfo = info[0].split(":");
    let start = parseInt(timeInfo[0]) * 60 + parseInt(timeInfo[1]);
    let end = 0;

    timeInfo = info[1].split(":");
    end = parseInt(timeInfo[0]) * 60 + parseInt(timeInfo[1]);

    let play = end - start;

    if (play > melodyInfo.length) {
      newMelody = "";

      // 나눈 몫 만큼 악보 처음부터 반복
      for (let i = 0; i < play / melodyInfo.length; i++)
        newMelody += melodyInfo;

      newMelody += melodyInfo.substring(0, play % melodyInfo.length);
      melodyInfo = newMelody.toString();
    } else {
      melodyInfo = melodyInfo.substring(0, play);
    }

    // if (melodyInfo.contains(m) && play > maxPlayTime) {
    if (melodyInfo.includes(m) && play > maxPlayTime) {
      answer = title;
      maxPlayTime = play;
    }
  }

  return maxPlayTime != -1 ? answer : "(None)";
}

function changeMelody(oldMelody) {
  oldMelody = oldMelody.replace(/C#/g, "H");
  oldMelody = oldMelody.replace(/D#/g, "I");
  oldMelody = oldMelody.replace(/F#/g, "J");
  oldMelody = oldMelody.replace(/G#/g, "K");
  let newMelody = oldMelody.replace(/A#/g, "L");

  return newMelody;
}
