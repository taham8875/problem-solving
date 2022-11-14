// Panoramix's Prediction

// Link : https://codeforces.com/contest/80/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

readline.on("line", (line) => (input = line));
readline.on("close", () => {
  input = input.split(" ").map(Number);
  let first = input[0];
  let second = input[1];
  let i = 0;

  function isPrime(n) {
    if (n === 2) {
      return true;
    } else if (n < 2 || n % 2 === 0) {
      return false;
    }
    for (let i = 3; i * i <= n; i += 2) {
      if (n % i === 0) {
        return false;
      }
    }
    return true;
  }
  for (i = first + 1; i <= 50; i++) {
    if (isPrime(i)) {
      break;
    }
  }
  i === second ? console.log("YES") : console.log("NO");
});