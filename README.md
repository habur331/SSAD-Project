# SSAD-Project 
team members B21-01:

Sadi Toirov s.tairov@innopolis.university  
Ruslan Khairov r.khairov@innopolis.university             
Maksim Insapov m.insapov@innopolis.university        
Zamira Galyautdinova z.galyautdinova@innopolis.university 

# Visitor Pattern
In this project, we decided to implement a pattern to solve the problem of making reports. Since we have different classes (AttendanceDb, Grades, and Payment Book DB) that work with the database and have basic methods for writing and reading, but do not have methods for returning the collection in the format of reports, we implemented the Visitor pattern. We have put the new behavior
in a separate class (implements Visitor), instead of multiplying it
in several classes at once. Objects with which it should
there was a related behavior, did not perform it on their own. Instead, they passed these objects
to the visitor's methods.
In our example, we have three classes that are elements (Attendance, Grades, and Payment Book DB) and two Visitor classes (ReportByStuddentIDVisitor and ReportByDateVisitor) that issue a report. However, the existence of the pattern will facilitate the creation of new element classes and observer classes with a new report design.
Step-by-step implementation of the pattern:

1. Create a visitor interface and declare in it the methods
   of "visiting" for each class of element that
   exists in the program.
2. Described the interface of the elements.
3. Implemented acceptance methods in all specific elements.
   They forward calls to the visitor method in which the parameter type matches the current element class.
4. A specific visitor class was created for each new behavior
   . We adapted this behavior to work with
   all types of elements by implementing all methods of the user interface.
5. HOD will create visitor objects, and then re-
   give them to the elements using the acceptance method.