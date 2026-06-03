package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.cr.EcoHogar.model.Service;
import ucr.ac.cr.EcoHogar.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;
//Obtener todos
    public List<Service>findAll(){
        return this.repository.findAll();
    }
//Obtener por nombre
    public Service findByName(String name){
        return this.repository.findByName(name);
    }
//Guardar servicio
    public Service save(Service service){
        Optional<Service>optional=this.repository.findById(service.getId());
        if (optional.isPresent()){
            return null;
        }
        return this.repository.save(service);
    }
}
