numbers_to_possible_values = {
  "0" => 2,
  "1" => 7,
  "2" => 2,
  "3" => 3,
  "4" => 3,
  "5" => 4,
  "6" => 2,
  "7" => 5,
  "8" => 1,
  "9" => 2
}

number = gets.chomp

first_digit = number[0]
second_digit = number[1]

puts numbers_to_possible_values[first_digit] * numbers_to_possible_values[second_digit]
