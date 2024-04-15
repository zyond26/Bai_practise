// B. Class Student implements KPIE
public class B_Student implements A_KPIE {
    String studentID;
    String name;
    int age;
    String gender;
    String specialization;

    public B_Student(String studentID, String name, int age, String gender, String specialization) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.specialization = specialization;

    }

    @Override
     public String toString() {
        return "ITStudent :  ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", specialization: " + specialization;
    } 
    public String getstudentID(){
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender(){
        return gender;
    }
    public String getspecialization(){
        return specialization;
    }

    public String getrole(){
        return " Student";
    }
    public double calculateKPI(){
        return 4.0;
    }

    @Override
    public String getRole() {
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }

}

