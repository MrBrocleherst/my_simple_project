package DataTypeOperations;

public class DataTypeOperations {

    // Overloaded add methods
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    // Overloaded multiply methods
    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public String multiply(String a, int b) {
        return a.repeat(b);
    }

    // Main method
    public static void main(String[] args) {
        DataTypeOperations operations = new DataTypeOperations();

        // Testing add methods
        System.out.println("Add int: " + operations.add(5, 10));         // Output: 15
        System.out.println("Add double: " + operations.add(5.5, 4.5));   // Output: 10.0
        System.out.println("Add string: " + operations.add("Hello, ", "World!")); // Output: Hello, World!

        // Testing multiply methods
        System.out.println("Multiply int: " + operations.multiply(3, 4));      // Output: 12
        System.out.println("Multiply double: " + operations.multiply(2.5, 4.0)); // Output: 10.0
        System.out.println("Multiply string: " + operations.multiply("Java", 3)); // Output: JavaJavaJava
    }
}
