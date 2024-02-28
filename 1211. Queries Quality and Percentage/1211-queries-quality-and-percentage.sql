-- Write your PostgreSQL query statement below
SELECT query_name,
    round(avg(rating::numeric / position), 2) AS quality,
    round(
        (sum((rating < 3)::int)::numeric / COUNT(*)) * 100,
        2
    ) AS poor_query_percentage
FROM Queries
WHERE query_name IS NOT NULL
GROUP BY query_name