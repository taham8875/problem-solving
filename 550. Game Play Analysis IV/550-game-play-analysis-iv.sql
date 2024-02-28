-- Write your PostgreSQL query statement below
WITH first_login AS (
    SELECT player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(
        COUNT(DISTINCT Activity.player_id)::numeric / (
            SELECT COUNT(DISTINCT Activity.player_id)
            FROM Activity
        ),
        2
    ) AS fraction
FROM Activity
    JOIN first_login ON Activity.player_id = first_login.player_id
WHERE event_date - first_login = 1