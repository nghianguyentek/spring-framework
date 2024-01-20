package vn.kihon.spring.boot.domain;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
}
