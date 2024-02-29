-- -- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT visited_on,
        sum(amount) AS amount
    FROM Customer
    GROUP BY visited_on
    ORDER BY visited_on
)
SELECT visited_on,
    sum (amount) over w AS amount,
    round(avg (amount) over w, 2) AS average_amount
FROM subquery window w AS (
        ORDER BY visited_on ROWS BETWEEN 6 preceding AND current ROW
    ) OFFSET 6