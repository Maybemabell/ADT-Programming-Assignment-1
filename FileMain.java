
import java.util.*;
import java.io.*;

public class FileMain {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "", choice = "", stuname = "", userinput = "";

        Vector<Student> data = new Vector<>();
        Vector<String> tempdata = new Vector<>();
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("input -n,-f,-l + file path or fileName or Search + StudentName + file path");
        System.out.println();
        userinput = input.nextLine();
        System.out.println();

        StringTokenizer inu = new StringTokenizer(userinput.trim(), " ");
        
            choice = inu.nextToken();
            if (choice.equals("-s") ) {
                stuname = inu.nextToken().toLowerCase();
                file = inu.nextToken();
            } else  {
                file = inu.nextToken();
            }
        
        

        File f = new File(file);
       

        Scanner inf = new Scanner(f);

        for (int i = 0; i < 7 && inf.hasNextLine(); i++) {
            inf.nextLine();
        }

        while (inf.hasNextLine()) {
            String line = inf.nextLine();
            StringTokenizer stu = new StringTokenizer(line.trim(), ",");
            if (stu.countTokens() >= 4) { // Ensure enough tokens
                stu.nextToken();
                data.add(new Student(stu.nextToken().trim(), stu.nextToken().trim(), stu.nextToken().trim()));
            }
        }

        switch (choice) {
            case "-n":
                for (int i = 0; i < data.size(); i++) {
                    tempdata.add(data.elementAt(i).getSID());
                }
                System.out.println("Sort by student Number");
                System.out.println();
                sortData(data, tempdata);
                break;

            case "-f":
                for (int i = 0; i < data.size(); i++) {
                    tempdata.add(data.elementAt(i).getFirstName());
                }
                System.out.println("Sort by student Firstname");
                System.out.println();
                sortData(data, tempdata);
                break;

            case "-l":
                for (int i = 0; i < data.size(); i++) {
                    tempdata.add(data.elementAt(i).getLastName());
                }
                System.out.println("Sort by student Lastname");
                System.out.println();
                sortData(data, tempdata);
                break;

            case "-s":
                System.out.println();
                searchStudent(data, stuname);
                break;

            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void sortData(Vector<Student> students, Vector<String> tempdata) {
        String tempForData;

        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (tempdata.elementAt(j).compareTo(tempdata.elementAt(j + 1)) > 0) {
                    Student temp = students.elementAt(j);
                    students.set(j, students.elementAt(j + 1));
                    students.set(j + 1, temp);

                    tempForData = tempdata.elementAt(j);
                    tempdata.set(j, tempdata.elementAt(j + 1));
                    tempdata.set(j + 1, tempForData);
                }
            }
        }

        for (Student i : students) {
            System.out.println(i);
        }

        System.out.println();
    }

    public static void searchStudent(Vector<Student> students, String Name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.elementAt(i).getFirstName().trim().equalsIgnoreCase(Name.trim())) {
                System.out.println("Found at index " + i);
                System.out.println(students.elementAt(i));
                System.out.println();
                return;
            }
        }
        System.out.println("Sorry, Not Found");
        System.out.println();
    }
}

//Users/maybe/Documents/coding/class_roaster67.csv
