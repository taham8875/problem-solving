-- Write your PostgreSQL query statement below
WITH count_lat_lon_tiv_2015 AS (
    SELECT *,
        COUNT(*) over(PARTITION by tiv_2015) AS count_tiv_2015,
        COUNT(*) over(PARTITION by lat, lon) AS count_lat_lon
    FROM Insurance
)
SELECT round(sum(tiv_2016)::numeric, 2) AS tiv_2016
FROM count_lat_lon_tiv_2015
WHERE count_tiv_2015 >= 2 -- tiv_2015 appeared twice
    AND count_lat_lon = 1 -- unique city