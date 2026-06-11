package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.DTO.UserLoginDto;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EcoServiceService ecoServiceService;

    @Autowired
    private DeviceService deviceService;


    //Login
    public User login(String email, String password)
    {
        return this.userRepository.login(email, password);
    }
    //Obtener todos
    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }//fin metodo


    //Obtener por id
    public User findByID(Integer id)
    {
        Optional<User> optional=this.userRepository.findById(id);
        if (optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }//fin metodo


    //Obtener por nombre
    public List<User> findByName(String name)
    {
        return this.userRepository.findByName(name);
    }//fin metodo


    //Metodo editar usuario
    public User editUser(Integer id, User userEdit)
    {
        Optional<User> userOp=this.userRepository.findById(id);
        if (userOp.isPresent())
        {
            User user=userOp.get();
            user=userEdit;
            return this.userRepository.save(user);
        }
        return null;
    }//fin metodo


    //Metodo save
    public User save(User user)
    {
        Optional<User> opt=this.userRepository.findById(user.getId());
        if(opt.isPresent())
        {
            return null;
        }
        return this.userRepository.save(user);
    }//fin metodo


    //Borrar usuario
     public void deleteUser(Integer id)
     {
         this.userRepository.deleteById(id);
     }//fin metodo


//metodo convertir usuario a DTO
    public UserLoginDto convertUserDTO(User user)
    {
        UserLoginDto dto=new UserLoginDto();
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        return dto;
    }//fin metodo


//metodo convertir lista a DTO
    public List<UserLoginDto> convertListDTO(List<User> listUser)
    {
        List<UserLoginDto> listDTO = new ArrayList<>();
        for (User user : listUser)
        {
            listDTO.add(this.convertUserDTO(user));
        }
        return listDTO;
    }//fin metodo


    public List<User> findAllByOrderByName()
    {
        return this.userRepository.findAllByOrderByName();
    }//fin metodo




//    IDEA: Pedir horas de agua por DÍA y electricidad por DÍA.
//     Otro calcular al mes

    public Double waterConsumptionPerMonth(Integer id)
    {
        return (ecoServiceService.getEcoService(id).get().getLitersOfWaterConsumedPd()*ecoServiceService.getEcoService(id).get().getWaterCostPerlit()) *30;
    }//fin metodo


    public Double ligthConsumptionPerMonth(Integer id)
    {
        return (ecoServiceService.getEcoService(id).get().getHoursOfLightPd()*ecoServiceService.getEcoService(id).get().getLightCostPerHour())*30;
    }//fin metodo



//  Otro calcular al año.
    public Double waterConsumptionPerYear(Integer id)
    {
        return this.waterConsumptionPerMonth(id)*12;
    }//fin metodo


    public Double lightConsumptionPerYear(Integer id)
    {
        return this.ligthConsumptionPerMonth(id)*12;
    }//fin metodo



//  Otro método que sea el índice ecológico
    public Double ecoIndex(Integer id)
    {
        //Generalizamos los gastos por persona
        Double waterMediaPerPerson = this.waterConsumptionPerMonth(id) / this.userRepository.getReferenceById(id).getMemberQuantity();
        Double ligthMediaPerPerson = this.ligthConsumptionPerMonth(id) / this.userRepository.getReferenceById(id).getMemberQuantity();
        Double devicesMediaPerPerson = this.deviceService.getDevice(id).get().getQuantity() / this.userRepository.getReferenceById(id).getMemberQuantity();


        /*Puntuaciones de consumo
        Gasto ideal de agua por persona =  5000 colones
        Gasto ideal de luz por persona  8000
        Electrodomesticos promedios que tiene una persona  5
         */

        Double waterPoint = waterMediaPerPerson / 5000;
        Double ligthPoint = ligthMediaPerPerson / 8000;
        Double devicePoint = devicesMediaPerPerson / 5;


        //Se calcula el índice ecológico
        return 100 * (0.4 * (waterPoint) + 0.4 * (ligthPoint) + 0.2 * (devicePoint));

        /*Indicador de valor
        0-60 Poco ecológico
        61-80 Mejorable
        81-100 Bueno
        101-120 Muy bueno
        >120 Excelente
         */
    }//fin metodo


}//fin clase
