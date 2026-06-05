package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.Device;
import ucr.ac.cr.EcoHogar.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;
//Guardar electrodoméstico
    public Device save(Device device) {
        Optional<Device> optional = this.repository.findById(device.getId());
        if (optional.isPresent()) {
            return null;
        }
        return this.repository.save(device);
    }
//Obtener por nombre
    public Device findByName(String name){
        Optional<Device> optional = this.repository.findByName(name);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
//Obtener todos
    public List<Device> findAll (){
        return this.repository.findAll();
    }



}
