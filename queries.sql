--Part 1
-- List of columns and their data types in the job table:

-- id: integer, primary key
-- employer: varchar(255)
-- name: varchar(255)
-- skills: varchar(255)

--Part 2
SELECT name
FROM employer
WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4
SELECT skill_name
FROM skill
INNER JOIN jobs_skill ON skill.skill_id = jobs_skill.skill_id
WHERE jobs_skill.job_id IS NOT NULL
ORDER BY skill_name;