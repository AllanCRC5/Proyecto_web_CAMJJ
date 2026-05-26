package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.cr.EcoHogar.model.Service;
import ucr.ac.cr.EcoHogar.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public List<Service>findAll(){
        return this.repository.findAll();
    }

    public Service findByName(String name){
        return this.repository.findByName(name);
    }

    public Service save(Service service){
        Optional<Service>optional=this.repository.findById(service.getId());
        if (optional.isPresent()){
            return null;
        }
        return this.repository.save(service);
    }
}
