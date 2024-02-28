-- Write your PostgreSQL query statement below
SELECT to_char(date_trunc('month', trans_date), 'YYYY-MM') AS MONTH,
    country,
    COUNT(*) AS trans_count,
    sum((state = 'approved')::int) AS approved_count,
    sum(amount) AS trans_total_amount,
    sum(
        CASE
            WHEN state = 'approved' THEN amount
            ELSE 0
        END
    ) AS approved_total_amount
FROM Transactions
GROUP BY MONTH,
    country