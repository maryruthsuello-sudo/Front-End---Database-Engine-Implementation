package databaseengine.backend;

public class Student {
   String student_name;
   int student_ID;
   String student_birthday;
   String student_address;
   String student_highschool;
   String student_category;
   String student_birthplace;

   public Student(String var1, int var2, String var3, String var4, String var5, String var6, String var7) {
      this.student_name = var1;
      this.student_ID = var2;
      this.student_birthday = var3;
      this.student_address = var4;
      this.student_highschool = var5;
      this.student_category = var6;
      this.student_birthplace = var7;
   }

   public String display() {
      return this.student_name + " | ID: " + this.student_ID + " | Birthday: " + this.student_birthday + " | Address: " + this.student_address + " | Highschool: " + this.student_highschool + " | Category: " + this.student_category + " | Birthplace: " + this.student_birthplace;
   }
}
