# Regular expression Problem solving

# Link : https://www.hackerrank.com/domains/regex

Regex_Pattern = r"\S{2}\s\S{2}\s\S{2}"	# Do not delete 'r'.

import re

print(str(bool(re.search(Regex_Pattern, input()))).lower())