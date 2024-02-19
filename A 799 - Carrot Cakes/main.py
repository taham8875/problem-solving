from math import ceil


def is_worthy_to_build_an_oven(
    number_of_cakes,
    time_to_bake_cakes,
    number_of_cakes_baked_at_same_time,
    time_to_build_an_oven,
) -> bool:
    total_time_to_bake_with_one_oven = (
        ceil(number_of_cakes / number_of_cakes_baked_at_same_time) * time_to_bake_cakes
    )
    time_to_build_and_bake_one_cake = time_to_build_an_oven + time_to_bake_cakes

    return total_time_to_bake_with_one_oven > time_to_build_and_bake_one_cake


def main():
    (
        number_of_cakes,
        time_to_bake_cakes,
        number_of_cakes_baked_at_same_time,
        time_to_build_an_oven,
    ) = map(int, input().split())

    answer = is_worthy_to_build_an_oven(
        number_of_cakes,
        time_to_bake_cakes,
        number_of_cakes_baked_at_same_time,
        time_to_build_an_oven,
    )

    if answer:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()
