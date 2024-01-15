package vn.kihon.utility;

import lombok.Getter;

@Getter
public class Response<T> {
    private String code;
    private String message;
    private T data;

    public Response<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public Response<T>  setMessage(String message) {
        this.message = message;
        return this;
    }

    public Response<T>  setData(T data) {
        this.data = data;
        return this;
    }
}
