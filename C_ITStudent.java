// C. IT Student class extends Student

class C_ITStudent extends B_Student {
    String specialization;

    public C_ITStudent(String name, String studentID, int age, String gender, String specialization) {
        super(name, studentID, age, gender,specialization);
        this.specialization = specialization;
    }

   public String toString() {
        return "ITStudent :  ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", specialization: " + specialization;
    } 
}