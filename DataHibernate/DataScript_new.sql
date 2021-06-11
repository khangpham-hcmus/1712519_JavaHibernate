drop database if exists `DangKyHocPhan`;
CREATE DATABASE `DangKyHocPhan` ;
use `DangKyHocPhan`;
/*Create table and configuration primary key*/
/*Table 1: Accounts Table*/
drop table if exists `Accounts`;
create table `Accounts`(
	`UserName` varchar(50),/*1*/
    `Pass` varchar(50),/*2*/
    `TypeOfAccount` int,
    constraint PK_Accounts primary key(`UserName`)
);
/**/
/*Table 2: TeacherManager*/
drop table if exists `TeacherManagers`;
create table `TeacherManagers`(
	`TeacherManagerID` varchar(10),/*1*/
	`TeacherManagerName` varchar(50),/*2*/
	`UserName` varchar(50),/*3*/
    constraint PK_TeacherManagers primary key (`TeacherManagerID`)  
);
/**/
/*Table 3:Classes*/
drop table if exists `Classes`;
create table `Classes`(
	`ClassID` varchar(10),/*1*/
    constraint PK_Classes primary key (`ClassID`)
);
/**/
/*Table4: Students*/
drop table if exists `Students`;
create table `Students`(
	`StudentID` varchar(10),/*1*/
    `ClassID` varchar(10),/*2*/
    `StudentName` varchar(50),/*3*/
    `Gender` varchar(6),/*4*/
    `UserName` varchar(50),/*5*/
    constraint PK_Students primary key (`StudentID`,`ClassID`)
);
/**/
/*Table5: MonHoc*/
drop table if exists `Subjects`;
create table `Subjects`(
	`SubjectId` varchar(10),
    `SubjectName` varchar(50), 
    `CreditNumber` int,
    constraint PK_Subjects primary key (`SubjectId`)
);
/**/
/*Table 6:HocKy*/
drop table if exists `Semesters`;
create table `Semesters`(
	`SemesterYear` varchar(4),/*1*/
    `SemesterName` varchar(3),/*2*/
    `DayBegin` varchar(10),/*3*/
    `DayEnd` varchar(10),/*4*/
    `Current` varchar(1),/*5*/
    constraint PK_Semesters primary key (`SemesterYear`,`SemesterName`)
);
/**/
/*Table 7: KhoaHoc*/
drop table if exists `Courses`;
create table `Courses`(
	`SemesterYear` varchar(4),/*1*/
    `SemesterName` varchar(3),/*2*/
    `SubjectID` varchar(10),/*3*/
    `ClassID` varchar(10),/*4*/   
    `TheoryTeacher` varchar(50),/*5*/
    `DayOfWeek` varchar(10),/*6*/
    `Shift` int,/*7*/
    `MaxSlot` int,/*8*/
    `Room` varchar(10),
    constraint PK_Courses primary key(`SemesterYear`,`SemesterName`,`SubjectID`,`ClassID`)
);
/**/
/*Table 8: Students_Courses*/
drop table if exists `Students_Courses`;
create table `StudentsCourses`(
		`StudentIDRegistrated` varchar(10),/*1*/
		`ClassIDRegistrated` varchar(10),/*2*/
        `SemesterYearCourses` varchar(4),/*3*/
		`SemesterNameCourses` varchar(3),/*4*/
		`SubjectIDCourses` varchar(10),/*5*/
        `ClassIDCourses` varchar(10),/*6*/
        constraint PK_Students_Courses primary key (`StudentIDRegistrated`,`ClassIDRegistrated`,`SemesterYearCourses`,`SemesterNameCourses`,`SubjectIDCourses`,`ClassIDCourses`)
);
/**/
/*FOREIGN KEY*/
/**/
/*==================================================*/
/*Configuration foreign key for TeacherManager*/
alter table teachermanagers
add constraint FK_TeacherManagers_Accounts_UserName
foreign key (UserName)
references  Accounts(UserName);
/**/
/**/
/*==================================================*/
/*Configuration foreign key for Students*/
alter table students
add constraint FK_Students_Classes_ClassID
foreign key (ClassID)
references  Classes(ClassID);
/**/
/**/
alter table students
add constraint FK_Students_Accounts_UserName
foreign key (UserName)
references  Accounts(UserName);
/**/
/*=================================================*/
/*Configuration foreign key for courses*/
alter table courses
add constraint FK_Courses_Subjects_SubjectID
foreign key(subjectid) 
references subjects(subjectid);
/**/
alter table  courses
add constraint FK_Courses_Classes_ClassID
foreign key(ClassID)
references classes(ClassID);
/**/
alter table  courses
add constraint FK_Courses_Semesters_SemesterYearSemesterName
foreign key(semesterYear,semesterName)
references Semesters(semesterYear,semesterName);
/*===================================================================*/
/**/
/*Configuration foreign key for StudentsCourses*/
alter table StudentsCourses
add constraint StudentsCourses_Students__StudentIDClassID
foreign key(StudentIDRegistrated,ClassIDRegistrated)
references Students(StudentID,ClassID);
/**/
/**/
alter table StudentsCourses
add constraint StudentsCourses_Courses__SemesterYearNameSubjectID
foreign key(SemesterYearCourses,SemesterNameCourses,SubjectIDCourses,ClassIDCourses)
references Courses(SemesterYear,SemesterName,SubjectID,ClassID);
/*=========================================================================================*/
/*INSERT EXAMPLES DATA*/
/**/
/*Accounts Table*/
insert into  Accounts values("giaovux","giaovux",1);
insert into  Accounts values("giaovuy","giaovuy",1);
insert into  Accounts values("giaovuz","giaovuz",1);
insert into  Accounts values("1712519","1712519",2);
insert into  Accounts values("1712505","1712505",2);
insert into  Accounts values("1712333","1712333",2);
insert into  Accounts values("1712444","1712444",2);
insert into  Accounts values("1712666","1712666",2);

/**/
/*Classes Table*/
insert into classes values("17CTT1");
insert into classes values("17CTT2");
insert into classes values("17CTT3");
insert into classes values("17CTT4");
/**/
/*Subjects Table*/
insert into subjects values("CSC10003","Object Oriented Programing",4);
insert into subjects values("CSC10006","Database",4);
insert into subjects values("CSC10009","Computer System",2);
insert into subjects values("CSC10001","Network Analysis",4);
insert into subjects values("CSC10008","Introduction Programing",4);
/**/
/*Semesters Table*/
/**/
insert into semesters values("2019","hk1","01/09/2019","01/01/2020","1");
insert into semesters values("2020","hk2","15/01/2020","01/06/2020","0");
insert into semesters values("2020","hk3","15/06/2020","15/08/2020","0");
insert into semesters values("2021","hk4","01/09/2021","01/01/2021","0");
insert into semesters values("2021","hk5","15/06/2020","15/08/2021","0");
/**/
/*Courses Table*/
/**/
insert into courses values("2019","hk1","CSC10003","17CTT1","Ho Tuan Thanh","2","1",100,"E102");
insert into courses values("2019","hk1","CSC10003","17CTT2","Ho Tuan Thanh","3","2",115,"E103");
insert into courses values("2020","hk2","CSC10003","17CTT4","Nguyen Van Khiet","5","1",132,"E104");
insert into courses values("2020","hk2","CSC10009","17CTT3","Thai Hung Van","3","1",110,"E105");
insert into courses values("2020","hk2","CSC10009","17CTT4","Thai Hung Van","4","1",125,"E106");
insert into courses values("2020","hk2","CSC10008","17CTT4","Thai Hung Van","6","1",140,"E107");
/**/
/*Students Table*/
/**/
insert into students values("1712519","17CTT4","Pham Vo Hoang Khang","Male","1712519");
insert into students values("1712505","17CTT1","Tran Minh Hoang Vuong","Male","1712505");
insert into students values("1712333","17CTT4","Nguyen Thi Minh Thuy","Female","1712333");
insert into students values("1712444","17CTT4","Tran Nguyen Thuy Tien","Female","1712444");
insert into students values("1712666","17CTT4","Nguyen Tran Huynh Tran","Female","1712666");
/**/
/*TeacherManager*/
/**/
insert into teachermanagers values("GVX01","Giao Vu X","giaovux");
insert into teachermanagers values("GVY02","Giao Vu Y","giaovuy");
insert into teachermanagers values("GVZ02","Giao Vu Z","giaovuz");
 /**/
 /*StudentsCoureses*/
 insert into StudentsCourses values("1712519","17CTT4","2019","hk1","CSC10003","17CTT1");
 insert into StudentsCourses values("1712333","17CTT4","2019","hk1","CSC10003","17CTT2");
 insert into StudentsCourses values("1712666","17CTT4","2020","hk2","CSC10008","17CTT4");
 insert into StudentsCourses values("1712444","17CTT4","2020","hk2","CSC10009","17CTT4");


 /**/
