public class Test {


    public static void main(String[] args) {

        IFunction target = new Button("SubmitClick");
        // 代理之前的
        target.click();
        System.out.println("------------");
        // 代理之后的
        IFunction proxy = new ProxyButton(target,"ProxySubmitClick");
        proxy.click();

    }


}
