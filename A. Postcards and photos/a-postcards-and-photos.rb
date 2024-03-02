input = gets.chomp

number_of_consecutive_characters = 1

number_of_visits_to_the_cloest = 0

for i in 0..input.length-1
  if number_of_consecutive_characters == 5
    number_of_visits_to_the_cloest += 1
    number_of_consecutive_characters = 1
  elsif input[i] == input[i+1]
    number_of_consecutive_characters += 1
  else
    number_of_visits_to_the_cloest += 1
    number_of_consecutive_characters = 1
  end
end

puts number_of_visits_to_the_cloest
