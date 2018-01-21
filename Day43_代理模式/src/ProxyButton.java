public class ProxyButton implements IFunction {
    // 被代理对象和代理对象实现同一个接口
    // 代理对象中必须要有被代理对象的引用
    private IFunction iFunction;
    private String roleName;
    @Override
    public void click() {
        System.out.println(roleName + " has been on clicked!~");
        if ("ProxySubmitClick".equals(roleName)){
            iFunction.click();
            System.out.println("Verify success!~");

        }else {
            System.out.println(roleName + " haven't jurisdiction for on click " + iFunction.getBtnName() + "!~");
        }
    }

    @Override
    public String getBtnName() {
        return null;
    }

    public ProxyButton(IFunction iFunction, String roleName) {
        this.iFunction = iFunction;
        this.roleName = roleName;
    }

    public ProxyButton(String roleName) {
        this.roleName = roleName;
    }

    public IFunction getiFunction() {
        return iFunction;
    }

    public void setiFunction(IFunction iFunction) {
        this.iFunction = iFunction;
    }
}
