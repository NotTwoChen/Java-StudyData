package util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

import static util.VerificationCode.*;

public class CodeResult implements Result {
    private static String code;

    public String getCode() {
        return code;
    }

    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        code = getInstance().output(ServletActionContext.getResponse().getOutputStream());
    }
}
