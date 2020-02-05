## Part 1: Test it with SQL

SELECT COLUMN_NAME, COLUMN_TYPE
FROM INFORMATION_SCHEMA.columns
WHERE table_name-'job';

output:

COLUMN_NAME     COLUMN_TYPE
id              int(11)
employer        varchar(255)
name            varchar(255)
skills          varchar(255)

## Part 2: Test it with SQL

SELECT name FROM techjobs.employer
WHERE location = "ST. LOUIS CITY";

name

## Part 3: Test it with SQL

DROP TABLE techjobs.job;

## Part 4: Test it with SQL


