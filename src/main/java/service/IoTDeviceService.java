package service;


import org.springframework.stereotype.Service;

@Service
public class IoTDeviceService {
    public IoTDeviceService() {
    }

    public void add() {
        System.out.println("IoTDevice added");
    }

    public void delete() {
        System.out.println("IoTDevice deleted");
    }

    public void update() {
        System.out.println("IoTDevice updated");
    }

    public void list() {
        System.out.println("IoTDevice listed");
    }
}
