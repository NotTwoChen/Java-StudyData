package action;

import com.opensymphony.xwork2.ActionSupport;

public class DecValAction extends ActionSupport {

    private String name;

    public String dec(){
        return SUCCESS;
    }
    public String dec2(){
        return SUCCESS;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
