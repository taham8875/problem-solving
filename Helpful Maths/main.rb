input = gets.chomp.split("+").map(&:to_i).sort

puts input.join("+")
