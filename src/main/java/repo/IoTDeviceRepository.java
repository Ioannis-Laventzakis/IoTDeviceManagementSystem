package repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.IoTDevice;

@Repository
public interface IoTDeviceRepository extends JpaRepository<IoTDevice, Long> {
    IoTDevice findByType(String type);
    IoTDevice findByStatus(String status);
}
