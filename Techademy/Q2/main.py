from student import Student
from school import School

class Main:
    def run(self):
        student1 = Student("Deep", "12th", 19)
        print("Student Object Display:")
        student1.display()
        
        print("\n------------------------------\n")
        
        school_student = School("Rony", "11th", 15)
        print("School Object Display:")
        school_student.SchoolStudentDisplay()

if __name__ == "__main__":
    main_program = Main()
    main_program.run()
