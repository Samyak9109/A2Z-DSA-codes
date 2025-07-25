
import java.util.*;

// Student class implementing Comparable for sorting by GPA descending
class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa  = gpa;
    }

    public String getName() { return name; }
    public double getGpa()  { return gpa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    // Sorting by GPA descending order
    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }
}

// Comparator to compare strings by their length (ascending order)
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

// Comparator to compare integers in descending order
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
    }
}

public class Arraylist {
    public static void main(String[] args) {

        // ================================
        // PART 1: Working with Student class and custom sorting
        // ================================
        System.out.println("=== PART 1: Student Sorting ===");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        // Comparator: GPA descending, then name ascending
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa)
                .reversed()
                .thenComparing(Student::getName);

        System.out.println("Original students list:");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
        System.out.println();

        // Custom sort using lambda (similar to your original code)
        System.out.println("Using lambda expression to sort students by GPA descending and name descending:");
        students.sort((o1, o2) -> {
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            } else if (o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
        System.out.println();

        // Using Comparator with thenComparing for GPA desc, Name asc
        System.out.println("Using Comparator.comparing with thenComparing (GPA desc, Name asc):");
        Collections.sort(students, comparator);
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));

        System.out.println("\n-----------------------------------------\n");

        // ================================
        // PART 2: ArrayList basic operations and examples
        // ================================
        System.out.println("=== PART 2: ArrayList Basic Operations ===");

        // Ways to create ArrayLists
        ArrayList<Integer> list = new ArrayList<>(15);
        List<String> list2 = new ArrayList<>();
        List<String> list3 = Arrays.asList("apple", "Banana", "Mango");
        String[] arr = {"apple", "Banana", "Mango"};
        List<String> list4 = Arrays.asList(arr);
        List<Integer> list5 = List.of(1, 2, 3);

        System.out.println(">>> Ways to create ArrayLists and Lists:");
        System.out.println("list3 from Arrays.asList: " + list3);
        System.out.println("list4 from Arrays.asList with array: " + list4);
        System.out.println("list5 immutable list from List.of: " + list5);
        System.out.println();

        System.out.println("Using list.add(value) method:");
        list.add(165);
        list.add(27);
        list.add(345);
        list.add(27);
        System.out.println("After adds: " + list);

        System.out.println("\nUsing list.get(index) method:");
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("\nTraversing list using for loop and list.get(i):");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("\nTraversing list using enhanced for loop:");
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("\nUsing list.contains(value) method:");
        System.out.println("Does list contain 345? " + list.contains(345));

        System.out.println("\nUsing list.remove(index) method:");
        list.remove(2);
        System.out.println("After removing element at index 2: " + list);

        System.out.println("\nUsing list.add(index, value) method:");
        list.add(2, 50);
        System.out.println("After inserting 50 at index 2: " + list);

        System.out.println("\nUsing list.set(index, value) method:");
        list.set(2, 30);
        System.out.println("After setting index 2 value to 30: " + list);

        list.trimToSize();
        System.out.println("\nCalled list.trimToSize() - capacity trimmed to list's current size.");
        System.out.println("Current list: " + list);

        System.out.println("\nUsing list.addAll(collection) method:");
        list.addAll(list5);
        System.out.println("After adding all from list5: " + list);

        // Adding more elements
        list.add(1);
        list.add(2);
        System.out.println("\nAfter adding elements 1 and 2:");
        System.out.println(list);

        System.out.println("\nUsing list.remove(Integer.valueOf(value)) method:");
        list.remove(Integer.valueOf(1)); // removes first '1'
        System.out.println("After removing first occurrence of 1: " + list);

        System.out.println("\n-----------------------------------------\n");

        // ================================
        // PART 3: Sorting Lists using Collections.sort and List.sort
        // ================================
        System.out.println("=== PART 3: Sorting Lists ===");

        System.out.println("Using Collections.sort(list) - ascending order:");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("\nUsing Collections.sort(list, Comparator.reverseOrder()) - descending order:");
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        System.out.println("\nUsing list.sort(Comparator.naturalOrder()) - ascending order:");
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        System.out.println("\nUsing list.sort(null) - sorts with natural ordering:");
        list.sort(null);
        System.out.println(list);

        System.out.println("\n-----------------------------------------\n");

        // ================================
        // PART 4: Custom Comparator classes and Lambda expressions
        // ================================
        System.out.println("=== PART 4: Custom Comparator and Lambdas ===");

        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("Banana");
        fruit.add("Date");
        fruit.add("Orange");
        fruit.add("PineApple");

        System.out.println("Initial fruit list: " + fruit);

        System.out.println("\nUsing custom StringLengthComparator to sort fruit by length ascending:");
        fruit.sort(new StringLengthComparator());
        System.out.println(fruit);

        System.out.println("\nSorting integer list in descending order using custom MyComparator:");
        list.sort(new MyComparator());
        System.out.println(list);

        System.out.println("\nUsing lambda expression to sort fruit by length descending:");
        fruit.sort((a, b) -> b.length() - a.length());
        System.out.println(fruit);

        System.out.println("\nUsing lambda expression to sort integer list in ascending order:");
        list.sort((a, b) -> a - b);
        System.out.println(list);

        System.out.println("\nEnd of demo.");
    }
}
