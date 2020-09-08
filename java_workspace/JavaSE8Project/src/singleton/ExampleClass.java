package singleton;
public class ExampleClass {
    //Instance
    private static final ExampleClass instance = new ExampleClass();

    //private construct
    private ExampleClass() {}

    public static ExampleClass getInstance() {
        return instance;
    }
}