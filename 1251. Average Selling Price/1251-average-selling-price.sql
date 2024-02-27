-- Write your PostgreSQL query statement below
-- I wonder why the f test case 16 considers a not sold product as a free product
SELECT Prices.product_id,
    coalesce(
        round(
            sum(UnitsSold.units * Prices.price)::numeric / sum(UnitsSold.units),
            2
        ),
        0
    ) AS average_price
FROM Prices
    LEFT JOIN UnitsSold ON Prices.product_id = UnitsSold.product_id
WHERE UnitsSold.purchase_date BETWEEN Prices.start_date AND Prices.end_date
    OR UnitsSold.product_id IS NULL
GROUP BY Prices.product_id;