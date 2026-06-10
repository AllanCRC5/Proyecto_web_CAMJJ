package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.cr.EcoHogar.model.Service;
import ucr.ac.cr.EcoHogar.repository.ServiceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EcoServiceService
{

    @Autowired
    private ServiceRepository repository;


    //Obtener todos
    public List<Service>findAll()
    {
        return this.repository.findAll();
    }


    //Obtener por nombre
    public List<Service> findByName(String name)
    {
        return this.repository.findByName(name);
    }


    //Guardar servicio
    public Service save(Service service)
    {
        Optional<Service>optional=this.repository.findById(service.getId());
        if (optional.isPresent()){
            return null;
        }
        return this.repository.save(service);
    }


    //buscar por id
    public Service findByID(Integer id)
    {
        Optional<Service> optional=this.repository.findById(id);
        if (optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }


    //Editar
    public Service editService(Integer id, Service editService)
    {
        Optional <Service> service = this.repository.findById(id);
        if(service.isPresent())
        {
             return this.repository.save(editService);
//        Service service = serviceOp.get();
//        service.setName(editService.getName());
//        service.setwaterCostPerlit(editService.getwaterCostPerlit());
//        service.setHoursOfLightPd(serviceEdit.getHoursOfLight());
//        service.setLightCostPerHour(serviceEdit.getLightCostPerHour());
//        service.setLitersOfWaterConsumedPd(serviceEdit.getLitersOfWaterConsumed());
        }//if
        return null;
    }


    //borrar servicio
    public void deleteService(Integer id)
    {
        this.repository.deleteById(id);
    }


}
