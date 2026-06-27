package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.DTO.EcoServiceResponse;
import ucr.ac.cr.EcoHogar.model.DTO.EcoServiveRequest;
import ucr.ac.cr.EcoHogar.model.EcoService;
import ucr.ac.cr.EcoHogar.repository.EcoServiceRepository;

import java.util.ArrayList;
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
    public List<EcoServiceResponse> findAll()
    {
        return this.convertList(this.repository.findAll());
    }


    // Buscar por id
    public EcoServiceResponse findByID(Integer id)
    {
        Optional<EcoService> optional = repository.findById(id);

        if (optional.isPresent())
        {
            return this.convertToResponse(optional.get());
        }

        return null;
    }


    // Obtener por nombre
    public EcoServiceResponse findByName(String name) {
        Optional<EcoService> optional = repository.findByName(name);
        if(optional.isPresent()){
            return this.convertToResponse(optional.get());
        }
        return null;

    }


    // Guardar servicio
    public EcoServiceResponse save(EcoServiveRequest request) {
        EcoService service = this.convertToEcoService(request);
        EcoService savedService = this.repository.save(service);
        return this.convertToResponse(savedService);
    }


    // Editar servicio
    public EcoServiceResponse editService(Integer id, EcoServiveRequest request) {
     Optional<EcoService> optional = repository.findById(id);

     if(optional.isPresent()){
         EcoService service = optional.get();

         service.setName(request.getName());
         service.setWaterCostPerlit(request.getWaterCostPerlit());
         service.setHoursOfLightPd(request.getHoursOfLightPd());
         service.setLightCostPerHour(request.getLightCostPerHour());
         service.setLitersOfWaterConsumedPd(request.getLitersOfWaterConsumedPd());

         EcoService update = repository.save(service);
         return this.convertToResponse(update);
     }
     return null;
    }


    // Eliminar servicio
    public void deleteService(Integer id)
    {
        this.repository.deleteById(id);
    }

    //Convertir la entidad a request
    public EcoServiveRequest convertToRequest(EcoService service){
        EcoServiveRequest request = new EcoServiveRequest();

        request.setId(service.getId());
        request.setName(service.getName());
        request.setWaterCostPerlit(service.getWaterCostPerlit());
        request.setHoursOfLightPd(service.getHoursOfLightPd());
        request.setLightCostPerHour(service.getLightCostPerHour());
        request.setLitersOfWaterConsumedPd(service.getLitersOfWaterConsumedPd());

        return request;
    }


    //Convertir entidad a response
    private EcoServiceResponse convertToResponse(EcoService service){
        return new EcoServiceResponse(
                service.getId(),
                service.getName(),
                service.getWaterCostPerlit(),
                service.getHoursOfLightPd(),
                service.getLightCostPerHour(),
                service.getLitersOfWaterConsumedPd()
        );
    }

    //convertir lista de enttidades a lista responde
    public List<EcoServiceResponse> convertList(List<EcoService> listService) {
        List<EcoServiceResponse> listResponse = new ArrayList<>();

        for(EcoService service : listService){
            listResponse.add(this.convertToResponse(service));
        }
        return listResponse;
    }

    //Convertir Request a entidad
    private EcoService convertToEcoService(EcoServiveRequest request)
    {
        EcoService service = new EcoService();

        service.setId(request.getId());
        service.setName(request.getName());
        service.setWaterCostPerlit(request.getWaterCostPerlit());
        service.setHoursOfLightPd(request.getHoursOfLightPd());
        service.setLightCostPerHour(request.getLightCostPerHour());
        service.setLitersOfWaterConsumedPd(request.getLitersOfWaterConsumedPd());

        return service;
    }


}