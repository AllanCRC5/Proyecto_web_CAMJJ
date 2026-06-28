package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.DTO.DeviceRequest;
import ucr.ac.cr.EcoHogar.model.DTO.DeviceResponse;
import ucr.ac.cr.EcoHogar.model.Device;
import ucr.ac.cr.EcoHogar.repository.DeviceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService
{
    @Autowired
    private DeviceRepository repository;



    // Obtener objeto para UserService
    public Optional<Device> getDevice(Integer id)
    {
        return this.repository.findById(id);
    }


    // Obtener por id
    public DeviceResponse findById(Integer id)
    {
        Optional<Device> optional = repository.findById(id);

        if(optional.isPresent())
        {
            Device device = optional.get();

            return new DeviceResponse(
                    device.getId(),
                    device.getName(),
                    device.getUsedLight(),
                    device.getQuantity()
            );
        }

        return null;
    }


    // Guardar electrodoméstico
    public DeviceResponse save(Device request)
    {
        Optional<Device> opt = this.repository.findById(request.getId());

        if(opt.isPresent())
        {
            return null;
        }

        Device device = this.convertToDevice(request);

        Device savedDevice = this.repository.save(device);

        return this.convertToResponse(savedDevice);
    }


    // Obtener por nombre
    public DeviceResponse findByName(String name)
    {
        Optional<Device> opt = this.repository.findByName(name);

        if(opt.isPresent())
        {
            return this.convertToResponse(opt.get());
        }

        return null;
    }



    // Obtener todos
    public List<DeviceResponse> findAll()
    {
        return this.convertList(this.repository.findAll());
    }



    // Editar device
    public DeviceResponse editDevice(Integer id, DeviceRequest request)
    {
        Optional<Device> optional = repository.findById(id);

        if(optional.isPresent())
        {
            Device device = optional.get();

            device.setName(request.getName());
            device.setUsedLight(request.getUsedLigth());
            device.setQuantity(request.getQuantity());

            Device updated = repository.save(device);

            return new DeviceResponse(
                    updated.getId(),
                    updated.getName(),
                    updated.getUsedLight(),
                    updated.getQuantity()
            );
        }

        return null;
    }


    // Eliminar
    public void deleteDevice(Integer id)
    {
        this.repository.deleteById(id);
    }

    public DeviceRequest convertToRequest(Device device)
    {
        DeviceRequest request = new DeviceRequest();

        request.setId(device.getId());
        request.setName(device.getName());
        request.setUsedLigth(device.getUsedLight());
        request.setQuantity(device.getQuantity());

        return request;
    }

    private DeviceResponse convertToResponse(Device device)
    {
        return new DeviceResponse(
                device.getId(),
                device.getName(),
                device.getUsedLight(),
                device.getQuantity()
        );
    }

    public List<DeviceResponse> convertList(List<Device> listDevice)
    {
        List<DeviceResponse> listResponse = new ArrayList<>();

        for(Device device : listDevice)
        {
            listResponse.add(this.convertToResponse(device));
        }

        return listResponse;
    }

    private Device convertToDevice(Device request)
    {
        Device device = new Device();

        device.setId(request.getId());
        device.setName(request.getName());
        device.setUsedLight(request.getUsedLight());
        device.setQuantity(request.getQuantity());

        return device;
    }
}