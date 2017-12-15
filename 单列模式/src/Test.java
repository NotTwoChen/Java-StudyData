/**
 *  一是某个类只能有一个实例
 *  二是它必须自行创建这个实例
 *  三是它必须自行向正规系统提供这个实例
 */
// 饿汉式
public class Test {
    private String name;
    private Test(){

    }
    static Test test = new Test();

    public static Test getTest() {
        return test;
    }
}
