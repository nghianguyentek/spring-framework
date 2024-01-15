package vn.kihon.utility.auth;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AuthRepository extends Repository<Auth, String> {
    Optional<Auth> findById(String id);
}
