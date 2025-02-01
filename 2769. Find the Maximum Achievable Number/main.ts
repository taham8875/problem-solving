function theMaximumAchievableX(num: number, t: number): number {
  // t = 1, output = num + 2
  // t = 2, output = num + 4
  // t = 3, output = num + 6
  // and so on

  return num + t * 2;
}
