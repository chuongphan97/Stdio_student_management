package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestFile {

    private static final String PATH = "student.csv";
    //phân biệt thrown với throws

    public static void main(String[] args) throws IOException {
        File file = new File(PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "a", "b", 10));
        students.add(new Student(2, "a", "b", 10));
        students.add(new Student(3, "a", "b", 10));
        students.add(new Student(4, "a", "b", 10));
        students.add(new Student(5, "a", "b", 10));
        students.add(new Student(6, "a", "b", 10));
        students.add(new Student(7, "a", "b", 10));
        students.add(new Student(8, "a", "b", 10));
        students.add(new Student(9, "a", "b", 10));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));

        for (Student student : students) {
            bufferedWriter.write(student.toStringCSV());
        }
        System.out.println("Ghi file thành công!");
        bufferedWriter.close();
        List<Student> students2 = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            students2.add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3])));
        }
        bufferedReader.close();
        for (Student s :
                students2) {
            System.out.println(s.toStringCSV());
        }

    }
}
