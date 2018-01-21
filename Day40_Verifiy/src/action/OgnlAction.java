package action;

import bean.Student;
import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport {

    private Student student;

    public String stu(){
        System.out.println(student);
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
