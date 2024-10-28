package repo;

import model.IoTDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IoTDeviceRepository extends JpaRepository<IoTDevice, Long> {
    List<IoTDevice> findByType(String type);
    List<IoTDevice> findByStatus(String status);
}
