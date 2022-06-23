# Insertion sort

elements = [5, 1, 7, 8, 100, 4, 23, 9, 13, 66, 14,
            4, 87, 11, 2, 0, 1, 4, 0, 1, 5, 6, 5, 7, 3]

print("Unsorted list")
print(elements)
for i in range(1, len(elements)):

    temp = elements[i]
    j = i - 1
    while (temp < elements[j] and j >= 0):
        elements[j + 1] = elements[j]
        j -= 1

    elements[j + 1] = temp


print("Sorted list")
print(elements)
