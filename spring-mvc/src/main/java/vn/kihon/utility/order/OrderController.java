package vn.kihon.utility.order;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.kihon.utility.Response;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping("/{id}")
    Response<Order> getAuth(@PathVariable String id) {
        return new Response<Order>().setCode("OK")
                .setData(orderRepository.findById(id).orElseThrow());
    }
}
