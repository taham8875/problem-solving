// Gravity Flip

// Link : https://codeforces.com/contest/405/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

readline.on("line", (line) => input.push(line));
readline.on("close", () => {
  cubes = input[1].split(" ").map(Number);
  cubes.sort((a, b) => a - b);
  console.log(cubes.join(" "));
});