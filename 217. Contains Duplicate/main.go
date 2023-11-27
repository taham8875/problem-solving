package main

import (
	"fmt"
)

func main() {
	fmt.Println("Hello, World!")
}

func containsDuplicate(nums []int) bool {
	existingNums := make(map[int]bool)
	for _, num := range nums {
		if existingNums[num] {
			return true
		}
		existingNums[num] = true
	}
	return false
}
