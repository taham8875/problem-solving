-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT product_id,
        min(year) AS first_year
    FROM Sales
    GROUP BY product_id
)
SELECT Sales.product_id,
    first_year,
    quantity,
    price
FROM Sales
    JOIN subquery ON Sales.product_id = subquery.product_id
WHERE Sales.year = subquery.first_year