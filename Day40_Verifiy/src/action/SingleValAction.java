package action;

import bean.Student;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class SingleValAction extends ActionSupport {

//    private Student student;
    private String single;

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String single(){
        return SUCCESS;
    }
    // 定义一个方法
    // 命名方式为:要验证的方法名+validate
    // 这个方法会由Struts2帮我们调用
    // 只会验证single方法
    public void validateSingle(){
        if (StringUtils.isBlank(single)){
            addFieldError("errorMsg","single不能为空!~");
        }
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
}
