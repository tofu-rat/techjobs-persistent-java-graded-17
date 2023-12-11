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
SELECT *
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;