import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class StudentManagementSystem extends JFrame {
    private JTextField txtStudentID;
    private JButton btnSearch, btnExit;
    private JTable tblStudents;

    private B_Student[] students;

    public StudentManagementSystem(B_Student[] students) {
        this.students = students;

        setTitle("Quản lý sinh viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();

        setVisible(true);
    }

    private void initializeComponents() {
        txtStudentID = new JTextField(10);

        btnSearch = new JButton("Tìm kiếm");
        btnSearch.setEnabled(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        btnExit = new JButton("Thoát");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        String[] columnNames = {"Mã sinh viên", "Họ tên", "Tuổi", "Giới tính", "Khoa"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblStudents = new JTable(model);
        for (B_Student student : students) {
            Object[] rowData = {student.studentID, student.name, student.age, student.gender,student.specialization};
            model.addRow(rowData);
        }
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Nhập mã sinh viên:"));
        panel.add(txtStudentID);
        panel.add(btnSearch);
        panel.add(btnExit);

        JScrollPane scrollPane = new JScrollPane(tblStudents);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void searchStudent() {
        String studentID = txtStudentID.getText().trim();
        if (studentID.length() != 3) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không hợp lệ");
            txtStudentID.requestFocus();
            return;
        }

        boolean found = false;
        for (int i = 0; i < tblStudents.getRowCount(); i++) {
            if (tblStudents.getValueAt(i, 0).equals(studentID)) {
                tblStudents.setRowSelectionInterval(i, i);
                tblStudents.scrollRectToVisible(tblStudents.getCellRect(i, 0, true));
                txtStudentID.requestFocus();
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không tìm thấy");
            txtStudentID.requestFocus();
        }
    }
     public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng sinh viên từ người dùng
        do {
            System.out.print("Nhap n (n > 0): ");
            while (!scanner.hasNextInt()) {
                System.out.println("nhap so nguyen duong.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);

        // Khởi tạo mảng sinh viên
        B_Student[] students = new B_Student[n];

        // Nhập thông tin sinh viên từ người dùng
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
                    System.out.println("nhap so nguyen cho tuoi.");
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
                    students[i] = new B_Student(studentID,name, age, gender,department);
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystem(students);
            }
        });

        scanner.close();
    }
}
