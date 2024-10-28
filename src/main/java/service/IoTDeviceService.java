package service;

import model.IoTDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.IoTDeviceRepository;


import java.util.List;

@Service
public class IoTDeviceService {

    private final IoTDeviceRepository iotDeviceRepository;

    @Autowired
    public IoTDeviceService(IoTDeviceRepository iotDeviceRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
    }

    public IoTDevice addDevice(IoTDevice device) {
        return iotDeviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        iotDeviceRepository.deleteById(deviceId);
    }

    public IoTDevice updateDevice(Long id, IoTDevice updatedDevice) {
        return iotDeviceRepository.findById(id)
                .map(device -> {
                    device.setType(updatedDevice.getType());
                    device.setStatus(updatedDevice.getStatus());
                    return iotDeviceRepository.save(device);
                })
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public List<IoTDevice> listDevices() {
        return iotDeviceRepository.findAll();
    }
}
