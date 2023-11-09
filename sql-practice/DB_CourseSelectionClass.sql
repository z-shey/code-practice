-- 创建选课系统数据库
CREATE DATABASE CourseSelection;

-- 使用选课系统数据库
USE CourseSelection;

-- 创建学生关系
CREATE TABLE Student
(
    Sno   INT PRIMARY KEY,
    Sname VARCHAR(100),
    Sage  SMALLINT,
    Ssex  VARCHAR(10),
    Sdept VARCHAR(50)
);

-- 创建课程关系
CREATE TABLE Course
(
    Cno     INT PRIMARY KEY,
    Cname   VARCHAR(50),
    Ccredit FLOAT,
    Cpno    SMALLINT
);

-- 创建学生选课关系
CREATE TABLE SC
(
    Sno   INT,
    Cno   INT,
    Grade FLOAT,
    PRIMARY KEY (Sno, Cno),
    FOREIGN KEY (Sno) REFERENCES Student (Sno),
    FOREIGN KEY (Cno) REFERENCES Course (Cno)
);
