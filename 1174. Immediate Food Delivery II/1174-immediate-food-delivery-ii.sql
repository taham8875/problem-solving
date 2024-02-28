-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT customer_id,
        min(order_date) AS first_order
    FROM Delivery
    GROUP BY customer_id
)
SELECT round(
        avg((order_date = customer_pref_delivery_date)::int) * 100,
        2
    ) AS immediate_percentage
FROM Delivery
    JOIN subquery ON Delivery.customer_id = subquery.customer_id
WHERE Delivery.customer_id = subquery.customer_id
    AND Delivery.order_date = subquery.first_order