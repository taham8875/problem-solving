
def mergeSort(elements):
    if (len(elements) == 1):
        return
    else:
        mid = len(elements) // 2
        leftArray = elements[:mid]
        rightArray = elements[mid:]

        mergeSort(leftArray)
        mergeSort(rightArray)

        i = j = k = 0
        while(i < len(leftArray) and j < len(rightArray)):
            if (leftArray[i] < rightArray[j]):
                elements[k] = leftArray[i]
                i += 1
                k += 1
            else:
                elements[k] = rightArray[j]
                j += 1
                k += 1

        while(i < len(leftArray)):
            elements[k] = leftArray[i]
            i += 1
            k += 1

        while(j < len(rightArray)):
            elements[k] = rightArray[j]
            j += 1
            k += 1


if __name__ == '__main__':
    elements = [12, 11, 13, 5, 6, 7, 9, 7, 8,
                5, 4, 1, 11, 18, 17, 246, 354, 36, 39]
    print("Given array is", end="\n")
    print(elements)
    mergeSort(elements)
    print("Sorted array is: ", end="\n")
    print(elements)
