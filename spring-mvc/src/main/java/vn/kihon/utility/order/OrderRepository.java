package vn.kihon.utility.order;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OrderRepository extends Repository<Order, String> {
    Optional<Order> findById(String id);
}
