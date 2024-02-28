-- Write your PostgreSQL query statement below
SELECT Register.contest_id,
    round(
        (
            COUNT(DISTINCT Register.user_id)::numeric /(
                SELECT COUNT(DISTINCT user_id)
                FROM Users
            )
        ) * 100,
        2
    ) AS percentage
FROM Register
    JOIN Users ON Register.user_id = Users.user_id
GROUP BY Register.contest_id
ORDER BY 2 DESC,
    1 ASC