// Easter Eggs

// Link : https://codeforces.com/contest/78/problem/B

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  let colors = "ROYGBIV";
  let output = "";
  output = colors.repeat(Math.floor(input / colors.length));

  for (let i = 0; input - output.length > colors.length - 4; i++) {
    output += colors[i];
  }

  let remains = input - output.length;

  for (let i = 0; i < remains; i++) {
    output += colors[(i + colors.length - 4) % colors.length];
  }

  console.log(output);
});