package it.allitude.validation.business.exceptions;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Error {

    private String message;
    private String code;
    private String path;
    private String method;
    private OffsetDateTime time;

    public OffsetDateTime getTime() {
        return time;
    }

    public Error setTime(OffsetDateTime time) {
        this.time = time;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Error setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Error setCode(String code) {
        this.code = code;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Error setPath(String path) {
        this.path = path;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public Error setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(message, error.message) && Objects.equals(code, error.code) && Objects.equals(path, error.path) && Objects.equals(method, error.method) && Objects.equals(time, error.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, code, path, method, time);
    }
}
