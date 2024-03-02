# reference: https://brilliant.org/wiki/finding-the-last-digit-of-a-power

base = 1378

power = gets.to_i

last_digits_of_power_8 = [8, 4, 2, 6]

case power
when 0
  print 1
else
  print last_digits_of_power_8[(power - 1) % 4]
end
