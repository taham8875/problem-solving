package main

import (
	"fmt"
)

func main() {
	fmt.Println("Hello, World!")
}

func twoSum(nums []int, target int) []int {
	for index, num := range nums {
		for index2, num2 := range nums {
			if index != index2 && num+num2 == target {
				return []int{index, index2}
			}
		}
	}
	return []int{}
}
