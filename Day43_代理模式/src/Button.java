public class Button implements IFunction {
    // 代理对象实现接口
    private String btnName;

    @Override
    public void click() {
        System.out.println(btnName+" has been on clicked!~");
    }

    public Button() {
    }

    public Button(String btnName) {
        this.btnName = btnName;
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }
}
