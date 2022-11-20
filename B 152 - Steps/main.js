// Steps

// Link : https://codeforces.com/contest/152/problem/B

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

readline.on("line", (line) => input.push(line));
readline.on("close", () => {
  class Point {
    constructor() {
      this.x = 0;
      this.y = 0;
    }
    translate(x, y) {
      this.x += x;
      this.y += y;
    }
  }

  [yardSizeX, yardSizeY] = input[0].split(" ").map(Number);
  let currentPosition = new Point();
  [currentPosition.x, currentPosition.y] = input[1].split(" ").map(Number);
  let numberOfVectors = +input[2];
  let dx,
    dy,
    stepsX,
    stepsY,
    minSteps,
    steps = 0;
  for (let i = 0; i < numberOfVectors; i++) {
    [dx, dy] = input[3 + i].split(" ").map(Number);
    if (dx > 0) {
      stepsX = Math.trunc((yardSizeX - currentPosition.x) / dx);
    } else if (dx < 0) {
      stepsX = Math.trunc((currentPosition.x - 1) / -dx);
    } else {
      stepsX = Number.MAX_VALUE;
    }

    if (dy > 0) {
      stepsY = Math.trunc((yardSizeY - currentPosition.y) / dy);
    } else if (dy < 0) {
      stepsY = Math.trunc((currentPosition.y - 1) / -dy);
    } else {
      stepsY = Number.MAX_VALUE;
    }
    minSteps = Math.min(stepsX, stepsY);
    currentPosition.translate(minSteps * dx, minSteps * dy);
    steps += minSteps;
  }
  console.log(steps);
});