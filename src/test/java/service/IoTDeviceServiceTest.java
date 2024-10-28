package service;

import model.IoTDevice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repo.IoTDeviceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IoTDeviceServiceTest {

    @Mock
    private IoTDeviceRepository iotDeviceRepository;

    @InjectMocks
    private IoTDeviceService iotDeviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addDevice_ShouldReturnSavedDevice() {
        // Arrange
        IoTDevice device = new IoTDevice();
        device.setType("Sensor");
        device.setStatus("Active");

        when(iotDeviceRepository.save(device)).thenReturn(device);

        // Act
        IoTDevice savedDevice = iotDeviceService.addDevice(device);

        // Assert
        assertNotNull(savedDevice);
        assertEquals("Sensor", savedDevice.getType());
        assertEquals("Active", savedDevice.getStatus());
        verify(iotDeviceRepository, times(1)).save(device);
    }

    @Test
    void deleteDevice_ShouldInvokeRepositoryDeleteById() {
        // Arrange
        Long deviceId = 1L;

        // Act
        iotDeviceService.deleteDevice(deviceId);

        // Assert
        verify(iotDeviceRepository, times(1)).deleteById(deviceId);
    }

    @Test
    void updateDevice_ShouldReturnUpdatedDevice_WhenDeviceExists() {
        // Arrange
        Long deviceId = 1L;
        IoTDevice existingDevice = new IoTDevice(deviceId, "Sensor", "Active", null);
        IoTDevice updatedDevice = new IoTDevice(deviceId, "Camera", "Inactive", null);

        when(iotDeviceRepository.findById(deviceId)).thenReturn(Optional.of(existingDevice));
        when(iotDeviceRepository.save(existingDevice)).thenReturn(existingDevice);

        // Act
        IoTDevice result = iotDeviceService.updateDevice(deviceId, updatedDevice);

        // Assert
        assertNotNull(result);
        assertEquals("Camera", result.getType());
        assertEquals("Inactive", result.getStatus());
        verify(iotDeviceRepository, times(1)).findById(deviceId);
        verify(iotDeviceRepository, times(1)).save(existingDevice);
    }

    @Test
    void updateDevice_ShouldThrowException_WhenDeviceNotFound() {
        // Arrange
        Long deviceId = 1L;
        IoTDevice updatedDevice = new IoTDevice(deviceId, "Camera", "Inactive", null);

        when(iotDeviceRepository.findById(deviceId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> 
            iotDeviceService.updateDevice(deviceId, updatedDevice)
        );

        assertEquals("Device not found", exception.getMessage());
        verify(iotDeviceRepository, times(1)).findById(deviceId);
        verify(iotDeviceRepository, never()).save(any(IoTDevice.class));
    }

    @Test
    void listDevices_ShouldReturnAllDevices() {
        // Arrange
        IoTDevice device1 = new IoTDevice(1L, "Sensor", "Active", null);
        IoTDevice device2 = new IoTDevice(2L, "Camera", "Inactive", null);

        when(iotDeviceRepository.findAll()).thenReturn(Arrays.asList(device1, device2));

        // Act
        List<IoTDevice> devices = iotDeviceService.listDevices();

        // Assert
        assertNotNull(devices);
        assertEquals(2, devices.size());
        verify(iotDeviceRepository, times(1)).findAll();
    }
}
