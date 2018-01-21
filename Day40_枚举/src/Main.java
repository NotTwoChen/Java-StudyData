public class Main {
    public static void main(String[] args) {
        Eunm.ccc();
        Eunm.ttt ttt = T.test(1,0);
        if (ttt == Eunm.ttt.SUCCESS){
            System.out.println("成功");
        }else if (ttt == Eunm.ttt.ERROR){
            System.out.println("失败");
        }
    }
}
