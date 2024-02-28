-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT product_id,
        (
            min('2019-08-16' - change_date) over(PARTITION by product_id)
        ),
        '2019-08-16'::date - (
            min('2019-08-16' - change_date) over(PARTITION by product_id)
        ) AS last_update
    FROM Products
    WHERE change_date <= '2019-08-16'
)
SELECT DISTINCT Products.product_id,
    (
        CASE
            WHEN last_update IS NULL THEN 10
            ELSE new_price
        END
    ) AS price
FROM Products
    LEFT JOIN subquery ON Products.product_id = subquery.product_id
WHERE change_date = last_update
    OR last_update IS NULL