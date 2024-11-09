package ie.atu.deliveryserviceapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Long id, Delivery deliveryDetails) {
        Delivery delivery = deliveryRepository.findById(id).orElse(null);
        if (delivery != null) {
            delivery.setDeliveryStatus(deliveryDetails.getDeliveryStatus());
            delivery.setDeliveryAddress(deliveryDetails.getDeliveryAddress());
            delivery.setDeliveryDate(deliveryDetails.getDeliveryDate());
            return deliveryRepository.save(delivery);
        }
        return null;
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
