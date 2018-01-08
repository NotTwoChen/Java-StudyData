public class Main {

    public static void main(String[] args) {

        LinkImo1 linkImo1 = new LinkImo1();
        linkImo1.add("A");
        linkImo1.add("B");
        linkImo1.add("C");
        linkImo1.set(0,"E");
        linkImo1.set(2,"L");
        linkImo1.remove("L");
        System.out.println(linkImo1.get(0));
        System.out.println(linkImo1.get(2));
    }
}
