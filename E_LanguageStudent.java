class E_LanguageStudent extends B_Student {
    public E_LanguageStudent(String studentID, String name, int age, String gender,String specialization) {
        super(studentID, name, age, gender,specialization);
    }

     public String toString() {
        return "ITStudent :  ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", specialization: " + specialization;
    } 
}