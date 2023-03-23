package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.ShopApplication;
import untitled.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = ShopApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void startDelivery(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
            deliveryStarted.publishAfterCommit();

         });
        */

    }
}
