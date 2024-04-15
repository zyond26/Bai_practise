class E_BusinessStudent extends B_Student {
    public E_BusinessStudent(String studentID, String name, int age, String gender,String specialization) {
        super(studentID, name, age, gender,specialization);
    }

    public String toString() {
        return "BusinessStudent:  ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}