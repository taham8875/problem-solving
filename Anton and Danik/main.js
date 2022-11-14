// Anton and Danik

// Link : https://codeforces.com/contest/734/problem/A

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

readline.on("line", (line) => input.push(line));
readline.on("close", () => {
  let numberOfGames = +input[0];
  let results = input[1];
  let anton = 0,
    danik = 0;
  for (let i = 0; i < numberOfGames; i++) {
    if (results[i] === "A") {
      anton++;
    } else {
      danik++;
    }
  }
  if (anton > danik) {
    console.log("Anton");
  } else if (anton < danik) {
    console.log("Danik");
  } else {
    console.log("Friendship");
  }
});