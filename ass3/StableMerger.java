package comp2011.ass3;
import java.util.Arrays;

class Student {
	String name;
	double grade;
	public Student(String n, double g) {
		name = n; grade = g;
	}
	public String toString() {  
		return "(" + name + ", " + grade + ")";
	}
}

public class StableMerger {
	public static Student[] merge1(Student[][] a) {
		return null;
	}
	
	public static Student[] merge2(Student[][] a) {
		return null;
	}
	
	public static void main(String[] args) {
		String[][] names = {{"Carrie Lam", "CY Leung", "Donald Tsang"}, 
		        {"Eason Chan", "Denise Ho", "Jennifer Chan", "Joey Yung", "Kay Tse", "Cheung Jacky"},
		        {"Winnie", "Mickey", "Teddy", "Peppa"}};
		double[][] grades = {{60, 60, 60}, {40, 60, 70, 80, 90, 95}, {0, 90, 95, 100}};
		Student[][] all = new Student[names.length][];
		for (int i = 0; i < names.length; i++) {
			all[i] = new Student[names[i].length];
			for (int j = 0; j < names[i].length; j++) 
			    all[i][j]= new Student(names[i][j], grades[i][j]);
		}
		System.out.println(Arrays.toString(merge1(all)));
		System.out.println(Arrays.toString(merge2(all)));
	}
}
