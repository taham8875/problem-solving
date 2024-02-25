#!/bin/bash

# Check if correct number of arguments are provided
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <problem_name> <file_extension>"
    exit 1
fi

# Assign arguments to variables
problem_name="$1"
file_extension="$2"

# Convert problem name to lowercase and replace spaces with hyphens
formatted_name=$(echo "$problem_name" | tr '[:upper:]' '[:lower:]' | tr ' ' '-'| tr -d '.')

# Create directory with problem name
mkdir "$problem_name"

# Create file with formatted name and specified extension
touch "$problem_name/$formatted_name.$file_extension"

echo "Directory and file created successfully:"
echo "Directory: $problem_name"
echo "File: $formatted_name.$file_extension"

# Navigate into the newly created directory
# Change into the newly created directory
if cd "$problem_name"; then
    echo "Changed directory: $(pwd)"
else
    echo "Failed to change directory: $problem_name"
    exit 1
fi

# Print the current working directory
echo "Current Directory: $(pwd)"