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
