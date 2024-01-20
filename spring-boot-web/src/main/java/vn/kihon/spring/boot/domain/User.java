package vn.kihon.spring.boot.domain;

import lombok.Builder;
import lombok.Data;

public interface User {
    String getId();
    void setId(String id);
    default User id(String id) {
        setId(id);
        return this;
    }
    String getName();
    void setName(String name);
    default User name(String name) {
        setName(name);
        return this;
    }
}
