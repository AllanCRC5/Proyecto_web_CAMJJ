package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.EcoService;
import ucr.ac.cr.EcoHogar.repository.EcoServiceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EcoServiceService
{

    @Autowired
    private EcoServiceRepository repository;


    //Obtener todos
    public List<EcoService>findAll()
    {
        return this.repository.findAll();
    }


    //Obtener por nombre
    public List<EcoService> findByName(String name)
    {
        return this.repository.findByName(name);
    }


    //Guardar servicio
    public EcoService save(EcoService service)
    {
        Optional<EcoService>optional=this.repository.findById(service.getId());
        if (optional.isPresent()){
            return null;
        }
        return this.repository.save(service);
    }


    //buscar por id
    public EcoService findByID(Integer id)
    {
        Optional<EcoService> optional=this.repository.findById(id);
        if (optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }


    //Editar
    public EcoService editService(Integer id, EcoService editService)
    {
        Optional <EcoService> service = this.repository.findById(id);
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
