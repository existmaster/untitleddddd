package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.ShopApplication;
import untitled.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = ShopApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
