package cn.chamas.util;

import org.springframework.stereotype.Component;

@Component
public class ResultBody {
    private Integer code = 200;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public void ready(){
        this.code = 200;
        this.msg = null;
        this.data = null;
    }
    @Override
    public String toString() {
        return "ResultBody{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
