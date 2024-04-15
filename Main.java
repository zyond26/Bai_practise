// // D. Main class

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Student student1 = new Student("Dieu",1 , 19, "nu");
//         System.out.println(student1.toString());

//         ITStudent itStudent1 = new ITStudent("Computer Science");
//         System.out.println(itStudent1.toString());
//     }
// }


import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Nhập số nguyên dương n
        do {
            System.out.print("Nhap (n > 0): ");
            while (!scanner.hasNextInt()) {
                System.out.println("please input interger number.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);

        // Khởi tạo mảng sinh viên
        B_Student[] students = new B_Student[n];

        // Nhập thông tin sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien thu " + (i + 1) + ":");
            System.out.print("Khoa (it/kd/nn): ");
            String department;
            do {
                department = scanner.next().toLowerCase(); // Chuyển đổi thành chữ thường để dễ so sánh
                if (!department.equals("it") && !department.equals("kd") && !department.equals("nn")) {
                    System.out.print("invalid. Vui long nhap lai (it/kd/nn): ");
                }
            } while (!department.equals("it") && !department.equals("kd") && !department.equals("nn"));

            System.out.print("studentID: ");
            String studentID = scanner.next();

            System.out.print("Name: ");
            String name = scanner.next();

            int age;
            do {
                System.out.print("Age: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Vui lòng nhập số nguyên cho tuoi.");
                    scanner.next();
                }
                age = scanner.nextInt();
            } while (age <= 0);

            System.out.print("Gender: ");
            String gender = scanner.next();

            // Tạo đối tượng sinh viên dựa trên khoa
            switch (department) {
                case "it":
                    students[i] = new C_ITStudent(studentID, name, age, gender, department);
                    break;
                case "kd":
                    students[i] = new E_BusinessStudent(studentID, name , age, gender,department);
                    break;
                case "nn":
                    students[i] = new E_LanguageStudent(studentID, name, age, gender,department);
                    break;
                default:
                    students[i] = new B_Student(name, studentID, age, gender,department);
            }
        }

        // Hiển thị thông tin mảng sinh viên
        System.out.println("\nLIST:");
        displayStudents(students);
    }

    // Hàm hiển thị thông tin mảng sinh viên
    public static void displayStudents(B_Student[] students) {
        for (B_Student student : students) {
            System.out.println(student);
        }
    }
}
