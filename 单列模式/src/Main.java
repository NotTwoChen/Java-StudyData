public class Main {
    public static void main(String[] args) {

        Test test = Test.getTest();
        Test test1 = Test.getTest();
        System.out.println(test == test1);
    }
}
