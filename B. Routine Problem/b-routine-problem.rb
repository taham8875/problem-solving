input = gets.chomp.split(" ").map(&:to_i)

width_s = input[0]
height_s = input[1]
width_m = input[2]
height_m = input[3]


if width_s * height_m >= width_m * height_s
  remainig_area = width_s * height_m - width_m * height_s
  total_area = width_s * height_m
else
  remainig_area = width_m * height_s - width_s * height_m
  total_area = width_m * height_s
end

gcd = remainig_area.gcd(total_area)

remainig_area = remainig_area / gcd
total_area = total_area / gcd

puts "#{remainig_area}/#{total_area}"
