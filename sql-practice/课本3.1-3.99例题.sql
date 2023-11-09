CREATE DATABASE Homework;
USE Homework;

-- Example 3.1
CREATE SCHEMA "S-C-SC" AUTHORIZATION db_accessadmin;

-- Example 3.2
CREATE SCHEMA AUTHORIZATION db_accessadmin;

-- Example 3.3
CREATE SCHEMA Test AUTHORIZATION db_accessadmin;
CREATE TABLE Tab1
(
    Col1 SMALLINT,
    Col2 INT,
    Col3 CHAR(20),
    Col4 NUMERIC(10, 3),
    Col5 DECIMAL(5, 2)
);

-- Example 3.4
-- DROP SCHEMA Test CASCADE;
DROP TABLE Tab1
DROP SCHEMA Test;

-- Example 3.5
CREATE TABLE Student
(
    Sno       CHAR(8) PRIMARY KEY,
    Sname     VARCHAR(20) UNIQUE,
    Ssex      CHAR(6),
    Sbirthday DATE,
    Smajor    VARCHAR(40)
)

-- Example 3.6
CREATE TABLE Course
(
    Cno     CHAR(5) PRIMARY KEY,
    Cname   VARCHAR(40) NOT NULL,
    Ccredit SMALLINT,
    Cpno    CHAR(5),
    FOREIGN KEY (Cpno) REFERENCES Course (Cno)
)

-- Example 3.7
CREATE TABLE SC
(
    Sno           CHAR(8),
    Cno           CHAR(5),
    Grade         SMALLINT,
    Semester      CHAR(5),
    Teachingclass CHAR(8),
    PRIMARY KEY (Sno, Cno),
    FOREIGN KEY (Sno) REFERENCES Student (Sno),
    FOREIGN KEY (Cno) REFERENCES Course (Cno)
)

-- Example 3.8
ALTER TABLE Student
    ADD Semail VARCHAR(30);

-- Example 3.9
ALTER TABLE Student
    ALTER COLUMN Sbirthday VARCHAR(20);

-- Example 3.10
ALTER TABLE Course
    ADD UNIQUE (Cname);

-- Example 3.11
DROP TABLE Student;

-- Example 3.12
CREATE VIEW CS_Student
AS
SELECT Sno, Sname, Ssex, Sbirthday, Smajor
FROM Student
WHERE Smajor = '计算机科学与技术';

DROP TABLE Student;
-- DROP TABLE Student;

SELECT *
FROM CS_Student;

-- Example 3.13
CREATE UNIQUE INDEX Idx_StudentSname ON Student (Sname);
CREATE UNIQUE INDEX Idx_CourseCname ON Course (Cname);
CREATE UNIQUE INDEX Idx_SCCno ON SC (Sno ASC, Cno DESC);

-- Example 3.14
-- ALTER INDEX Idx_SCCno RENAME TO Idx_SCSnoCno;
EXEC sp_rename 'dbo.SC.Idx_SCCno', 'Idx_SCSnoCno', 'INDEX';

-- Example 3.15
DROP INDEX Idx_StudentSname;

-- Example 3.16
SELECT Sno, Sname
FROM Student;

-- Example 3.17
SELECT Sname, Sno, Smajor
FROM Student;

-- Example 3.18
SELECT *
FROM Student;
-- SELECT Sno, Sname, Ssex, Sbirthdate, Smajor FROM Student

-- Example 3.19
-- SELECT Sname, (EXTRACT(2023-10-22)) - EXTRACT(2003-12-5)
-- FROM Student;
SELECT Sname, DATEDIFF(YEAR, Sbirthday, GETDATE()) AS Age
FROM Student;

-- Example 3.20
SELECT Sname, 'DATA OF BIRTH: ', Sbirthday, Smajor
FROM Student;

-- Example 3.21
SELECT Sno
FROM SC;
SELECT DISTINCT Sno
FROM Student;
SELECT ALL Sno
FROM Student;

-- Example 3.22
SELECT Sname
FROM Student
WHERE Smajor = 'CS'

-- Example 3.23
SELECT Sname, Ssex
FROM Student
WHERE YEAR(Sbirthday) <= 2000;

-- Example 3.24
SELECT DISTINCT Sno
FROM SC
WHERE Grade < 60;

-- Example 3.25
SELECT Sname, Sbirthday, Smajor
FROM Student
WHERE DATEDIFF(YEAR, Sbirthday, GETDATE()) BETWEEN 20 AND 30;

-- Example 3.26
SELECT Sname, Sbirthday, Smajor
FROM Student
WHERE DATEDIFF(YEAR, Sbirthday, GETDATE()) NOT BETWEEN 20 AND 23;

-- Example 3.27
SELECT Sname, Ssex
FROM Student
WHERE Smajor IN ('CS', 'MA');

-- Example 3.28
SELECT Sname, Ssex
FROM Student
WHERE Smajor NOT IN ('JAVA', 'CPP');

-- Example 3.29
SELECT *
FROM Student
WHERE Sno LIKE '202210';

-- Example 3.30
SELECT Sname, Sno, Ssex
FROM Student
WHERE Sname LIKE '刘%';

-- Example 3.31
SELECT Sno, Sname
FROM Student
WHERE Sno LIKE '2018%'

-- Example 3.32
SELECT Cname, Cno
FROM Course
WHERE Cno LIKE '18__6';

-- Example 3.33
SELECT Sname, Sno, Ssex
FROM Student
WHERE Sname NOT LIKE '刘%';

-- Example 3.34
SELECT Cno, Ccredit
FROM Course
WHERE Cname LIKE 'DB\_Design' ESCAPE '\';

-- Example 3.35
SELECT *
FROM Course
WHERE Cname LIKE 'DB\_%i__' ESCAPE '\';

-- Example 3.36
SELECT Sno, Cno
FROM SC
WHERE Grade IS NULL;

-- Example 3.37
SELECT Sno, Cno
FROM SC
WHERE Grade IS NOT NULL;

-- Example 3.38
SELECT Sname, Ssex
FROM Student
WHERE Smajor = 'CS'
   OR Smajor = 'WEB';

-- Example 3.39
-- SELECT Sno, Grade
-- FROM SC
-- WHERE Cno = '8013'
-- GROUP BY Grade DESC;
SELECT Sno, Grade
FROM SC
WHERE Cno = '8013'
GROUP BY Sno, Grade
ORDER BY Grade DESC;

-- Example 3.40
SELECT *
FROM SC
GROUP BY Cno, Grade, Sno, Semester, Teachingclass
ORDER BY Cno, Grade DESC;

-- Example 3.41
SELECT COUNT(*)
FROM Student;

-- Example 3.42
SELECT COUNT(DISTINCT Sno)
FROM SC;

-- Example 3.43
SELECT AVG(Grade)
FROM SC
WHERE Cno = '4050';

-- Example 3.44
SELECT MAX(Grade)
FROM SC
WHERE Cno = '4155';

-- Example 3.45
SELECT SUM(Ccredit)
FROM SC,
     Course
WHERE Sno = '202000'
  AND SC.Cno = Course.Cno;

-- Example 3.46
SELECT Cno, COUNT(Sno)
FROM SC
GROUP BY Cno;

-- Example 3.47
SELECT Sno
FROM SC
WHERE Semester = '20192'
GROUP BY Sno
HAVING COUNT(*) > 10;

-- Example 3.48
SELECT Sno, AVG(Grade)
FROM SC
GROUP BY Sno
HAVING AVG(Grade) >= 90;

-- Example 3.49
-- SELECT Sno
-- FROM SC, Course
-- WHERE Course.Cname = 'DATABASE' AND SC.Cno = Course.Cno
-- ORDER BY Grade DESC
-- LIMIT 10;
SELECT TOP 10 Sno
FROM SC
         INNER JOIN Course ON SC.Cno = Course.Cno
WHERE Course.Cname = 'DATABASE'
ORDER BY Grade DESC;

-- Example 3.50
-- SELECT Sno, AVG(Grade)
-- FROM SC
-- GROUP BY Sno
-- ORDER BY AVG(Grade) DESC
-- LIMIT 5 OFFSET 2;
SELECT Sno, AVG(Grade)
FROM SC
GROUP BY Sno
ORDER BY AVG(Grade) DESC
OFFSET 2 ROWS FETCH NEXT 5 ROWS ONLY;

-- Example 3.51
SELECT Student.*, SC.*
FROM Student,
     SC
WHERE Student.Sno = SC.Sno;

-- Example 3.52
SELECT Student.Sno, Sname, Ssex, Sbirthday, Smajor, Cno, Grade
FROM Student,
     SC
WHERE Student.Sno = SC.Sno;

-- Example 3.53
SELECT Student.Sno, Sname
FROM Student,
     SC
WHERE Student.Sno = SC.Sno
  AND SC.Cno = '05000'
  AND SC.Grade > 90;

-- Example 3.54

-- Example 3.55
SELECT Student.Sno, Sname, Ssex, Sbirthday, Cno, Grade
FROM Student
         LEFT OUTER JOIN SC ON Student.Sno = SC.Sno;

-- Example 3.56
SELECT Student.Sno, Sname, Cname, Grade
FROM Student,
     SC,
     Course
WHERE Student.Sno = SC.Sno
  AND SC.Sno = Course.Cno;

-- Example 3.57
