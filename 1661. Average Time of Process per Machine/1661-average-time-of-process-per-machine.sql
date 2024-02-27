-- Write your PostgreSQL query statement below
-- using aggregate function
SELECT
    machine_id,
    round(
        sum(
            CASE
                WHEN activity_type = 'start' THEN -1 * timestamp
                ELSE timestamp
            END
        ) :: numeric / (
            SELECT
                count(DISTINCT process_id)
        ),
        3
    ) AS processing_time
FROM
    Activity
GROUP BY
    machine_id;

-- Write your PostgreSQL query statement below
-- using joins
SELECT
    a1.machine_id,
    round(AVG(a2.timestamp - a1.timestamp) :: numeric, 3) AS processing_time
FROM
    Activity a1
    JOIN Activity a2 ON a1.machine_id = a2.machine_id
WHERE
    a1.process_id = a2.process_id
    AND a1.activity_type = 'start'
    AND a2.activity_type = 'end'
GROUP BY
    a1.machine_id