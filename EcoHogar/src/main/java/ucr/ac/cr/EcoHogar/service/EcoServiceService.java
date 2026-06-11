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


    // Obtener objeto para UserService
    public Optional<EcoService> getEcoService(Integer id)
    {
        return this.repository.findById(id);
    }


    // Obtener todos
    public List<EcoService> findAll()
    {
        return this.repository.findAll();
    }


    // Obtener por nombre
    public List<EcoService> findByName(String name)
    {
        return this.repository.findByName(name);
    }


    // Guardar servicio
    public EcoService save(EcoService service)
    {
        return this.repository.save(service);
    }


    // Buscar por id
    public EcoService findByID(Integer id)
    {
        Optional<EcoService> optional = this.repository.findById(id);

        if (optional.isPresent())
        {
            return optional.get();
        }

        return null;
    }


    // Editar servicio
    public EcoService editService(Integer id, EcoService editService)
    {
        Optional<EcoService> serviceOpt = this.repository.findById(id);

        if(serviceOpt.isPresent())
        {
            EcoService service = serviceOpt.get();

            service.setName(editService.getName());
            service.setWaterCostPerlit(editService.getWaterCostPerlit());
            service.setHoursOfLightPd(editService.getHoursOfLightPd());
            service.setLightCostPerHour(editService.getLightCostPerHour());
            service.setLitersOfWaterConsumedPd(editService.getLitersOfWaterConsumedPd());

            return this.repository.save(service);
        }

        return null;
    }


    // Eliminar servicio
    public void deleteService(Integer id)
    {
        this.repository.deleteById(id);
    }



}