package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.Device;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {


    @Autowired
    private DeviceRepository repository;


    //Obtener todos
    public List<Device> findAll (){
        return this.repository.findAll();
    }//fin del metodo findAll


    //Obtener por id
    public Device findById(Integer id){
        Optional<Device> optional = this.repository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }//fin del metodo findById


    //Obtener por nombre
    public Device findByName(String name){
        Optional<Device> optional = this.repository.findByName(name);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }


    //Metodo editar Device
    public Device editDevice(Integer id, Device editD){
        Optional<Device> optional = this.repository.findById(id);
        if (optional.isPresent()){
            Device device = optional.get();
            device = editD;
            return this.repository.save(device);
        }
        return null;
    }//fin del metodo Edit


    //Guardar electrodoméstico
    public Device save(Device device) {
        Optional<Device> optional = this.repository.findById(device.getId());
        if (optional.isPresent()) {
            return null;
        }
        return this.repository.save(device);
    }//fin del metodo Save


    public void deleteDevice(Integer id){
        this.repository.deleteById(id);
    }//fin del metodo deleteDevice
}
