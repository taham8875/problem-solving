-- Write your PostgreSQL query statement below
-- with window functions
WITH temperature_lag AS (
    SELECT
        id,
        recorddate,
        temperature,
        lag (temperature) OVER (
            ORDER BY
                recorddate
        ) AS lag_temp,
        lag (recorddate) OVER (
            ORDER BY
                recorddate
        ) AS lag_date
    FROM
        Weather
)
SELECT
    id
FROM
    temperature_lag
WHERE
    temperature > lag_temp
    AND recorddate - lag_date = 1 -- to make sure to handle the case of missing dates