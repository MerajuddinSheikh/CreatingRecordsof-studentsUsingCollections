package ArrayPogramme;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayProgramme {

    public static void main(String[] args) throws Exception {

        String filepath = "h:\\library.csv";
        String filecontents = "";
        ArrayList<String> LinesRead = new ArrayList<String>();
        //LinkedList<String> LinesRead = new LinkedList<>();
        //Student sobj;
        ArrayList<Student> Records = new ArrayList();
        //LinkedList<Student> Records = new LinkedList<>();
        //System.out.println(filepath);
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                LinesRead.add(currentline);// Add line to String Arraylist


                currentline = br.readLine();
            }
            br.close();
            fr.close();
            System.out.println(LinesRead.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rollno = 0, age = 0;
        String token, name = null;
        int count = 0;
        int size = LinesRead.size();
        System.out.println("The size of Arraylist in which lines from file are read is " + size + "\n");
        StringTokenizer stz;

        // Now USe Stringtokenizer to sepearte tokens so that seprated token can be rollno, name and age for Student object
        // initialization.

        //using enhanced loop

        for (String s : LinesRead) {
            //System.out.println("Line read from file : " + s);
            stz = new StringTokenizer(s, ",");
            //System.out.println("No of Tokens is :" + stz.countTokens());
            count = 1;
            while (stz.hasMoreElements()) {
                token = stz.nextToken();
                switch (count) {
                    case 1: {
                        rollno = Integer.parseInt(token); // first token is rollno
                        break;
                    }
                    case 2: {
                        name = token; // second token is name
                        break;
                    }
                    case 3: {
                        age = Integer.parseInt(token); // third token is age
                        break;
                    }
                }
                count++;
            } // while loop ends here

            Student sobj = new Student(rollno, name, age);
            Records.add(sobj);
            //System.out.println("Tokens seperated :" + rollno + " " + name + " " + age + "\n");
        } // for loop ends here*/

        System.out.println("Now printing thru Objects ");
        for (Student s : Records)
            System.out.println(" " + s.rollno + " " + s.name + " " + s.age);

        System.out.println("\n\nNow printing selected Objects -age");
        for (Student s : Records) {
            if (s.age == 12)
                System.out.println(" " + s.rollno + " " + s.name + " " + s.age);
        }

        System.out.println("\n\nNow printing selected Objects -name starts with ");
        for (Student s : Records) {
            if (s.name.startsWith("S"))
                System.out.println(" " + s.rollno + " " + s.name + " " + s.age);
        }


    }
}

class Student {
    int rollno;
    String name;
    int age;

    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }
}





















