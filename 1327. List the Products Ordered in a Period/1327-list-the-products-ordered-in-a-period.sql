-- Write your PostgreSQL query statement below
WITH Orders_in_months AS (
    SELECT product_id,
        to_char(date_trunc('month', order_date), 'YYYY-MM') AS MONTH,
        unit
    FROM Orders
)
SELECT Products.product_name,
    sum(Orders_in_months.unit) AS unit
FROM Orders_in_months
    JOIN Products ON Orders_in_months.product_id = Products.product_id
WHERE MONTH = '2020-02'
GROUP BY Products.product_name
HAVING sum(Orders_in_months.unit) >= 100
ORDER BY sum(Orders_in_months.unit) DESC