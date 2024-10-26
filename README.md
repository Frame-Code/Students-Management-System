# Students managment system
A personal project that tries to simulate a system to manage the enrolment, registration and pensions of students in a private educational institution.
The program would be mainly intended for the staff of a certain institution in charge of enrolling students at the beginning of each new cycle in the educational institution. 


### Features

- Enrolling new students entering the educational institution and storing all their information in the data base;
- Enrolling students who have already been registered in previous cycles, that is the student is already registered in the database but without any course and classroom assigned and by a cancelled enrolment status ‘Cancelado’, when enrolling the student these parameters change;
- Manage by course and by classroom each enrolled student, being able to access their main information;
- With reference to the above, it is possible to register and manage the pensions of each student, being able to generate new pension payments and to verify which was the last month of payment.  A student with overdue payments will automatically have an ‘Inactivo’ enrolment status, those with up-to-date payments will have an ‘Activo’ enrolment status;
- It is possible to cancel all the enrolments of the students of a selected course, these students will have the enrolment status cancelled ‘Anulada';
- It is possible to view all students with cancelled enrolments, to delete them, to delete them or to directly delete all students with cancelled enrolments;
- You can create, edit and delete courses with n number of unique classrooms per course, assign subjects to each course, number of seats for each classroom you have;
- It is possible to create, edit and delete subjects, so that these can be assigned to each course (this is only for practicality purposes, as it is not completely necessary to have this option, but it is there);
- Finally you have the option to register general data of the institution such as the type of educational institution, the name of the institution, the value of the enrolment fee, the value of the board or tuition, the start date of the new cycle and the end date of the cycle. This data is used to be displayed in different parts of the project, for example when enrolling a new student, the values of tuition and fees are ready for the user's efficiency and speed;

### How to test it
First **Is necessary a java version 17.0.6 2023-01-17 or later** Install it in this [link](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
And obviously have an internet connection for the programme to connect to the database.

After that, **download the file .jar to be execute in this [link](https://github.com/Frame-Code/Students-Management-System/raw/refs/heads/main/Gestion_Alumnos-1.0.jar)** 
Or find the file named Gestion_Alumnos-1.0.jar at the root of this project

Now, to execute the file mentioned in linux or windows terminal:
1. Change to the directory where the file is downloaded. For example: 
```bash
cd Downloads/
```
2.  Execute the file with this command (remeber the java version mentioned):
```bash
java -jar  Gestion_Alumnos-1.0.jar
```
**Note:** To run the file on windows without the terminal **you only need to double click on the .jar file.**

#### You should see a window like this:
![The principal page of the app](Principal_page.png)


**if you need to test it with a database of yours, follow these steps**
1. Open the file with a file archiver or manager as winrar, 7zip or the archive manager to default Ubuntu
2. In the root folder there is the file .env, open it and modify the data base access predefined with you credentials access, for example:
```bash
DB_HOST=localhost
DB_PORT=3306
DB_NAME='name of the database without inverted commas'
DB_USER='name of the user without inverted commas'
DB_PASSWORD='password of the user without inverted commas'
```
