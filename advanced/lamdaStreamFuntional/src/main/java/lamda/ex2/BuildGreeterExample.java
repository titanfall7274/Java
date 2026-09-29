package lamda.ex2;

public class BuildGreeterExample {

    public static StringFuncion buildGreeter(String greeting) {
        return name -> greeting + ", " + name;
    }

    public static void main(String[] args) {
        StringFuncion greeting1 = buildGreeter("Hello");
        System.out.println("greeting1.apply('Jiho') = " + greeting1.apply("Jiho"));
    }
}
