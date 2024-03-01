number_of_cubes = gets.chomp.to_i

cubes_in_string = gets.chomp

cubes = cubes_in_string.split(" ").map(&:to_i)

cubes.sort!

puts cubes.join(" ")
