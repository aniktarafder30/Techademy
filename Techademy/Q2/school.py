from student import Student

class School(Student):
    def __init__(self, name, grade, age):
        super().__init__(name, grade, age)

    def SchoolStudentDisplay(self):
        print("School Student Details:")
        self.display()
