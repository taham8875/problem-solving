first_number = gets.chomp.to_i

second_number = gets.chomp.to_i

sum1_filtered = first_number + second_number



first_number_without_zeros = first_number.to_s.gsub('0', '').to_i

second_number_without_zeros = second_number.to_s.gsub('0', '').to_i

sum2 = first_number_without_zeros + second_number_without_zeros

sum2_filtered = (sum1_filtered).to_s.gsub('0', '').to_i



if sum2 == sum2_filtered
  puts 'YES'
else
  puts 'NO'
end
