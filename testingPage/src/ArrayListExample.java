

 java.util.ArrayList;

public class ArrayListExample {

    ArrayList<String> psy101 = new ArrayList<>(Student);

    psy101.add(new Student("Bob",2.9));
    psy101.add(new Student("Susie", 3.6))

}

 public class Student {
     private String Name;
     private double gpa;


     public Student(String name, double gpa){
         this.Name = name;
         this.gpa = gpa;
     }

     public String getName(){
         return this.Name;
     }

     public String getName(String newName){
         return (this.Name = newName);
     }

     public double getGPA(){
         return this.GPA;
     }

     public double setGPA(double new GPA){
         return (this.GPA = newGPA);
     }

     @Override
     public String toString(){
         return String.format("%s\t%f",this.Name, this.GPA);
     }
 }
