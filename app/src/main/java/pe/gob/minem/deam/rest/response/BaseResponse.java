package pe.gob.minem.deam.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ronaldvelasquez on 4/01/17.
 */

public class BaseResponse<T> {
    @SerializedName("message")
    private String message;
    @SerializedName("error")
    private boolean isError;
    @SerializedName("data")
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
