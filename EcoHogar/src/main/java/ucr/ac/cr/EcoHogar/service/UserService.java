package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.DTO.RegisterRequest;
import ucr.ac.cr.EcoHogar.model.DTO.UserRequest;
import ucr.ac.cr.EcoHogar.model.DTO.UserResponse;
import ucr.ac.cr.EcoHogar.model.Device;
import ucr.ac.cr.EcoHogar.model.EcoService;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EcoServiceService ecoServiceService;


    // Buscar todos
    public List<UserResponse> findAll()
    {
        return this.convertList(this.userRepository.findAll());
    }


    // Buscar por ID
    public UserResponse findByID(Integer id)
    {
      User user = this.findUserById(id);

        if (user == null){
            return null;
        }//fin if
        return this.convertToResponse(user);
    }//fin metodo


    // metodo que se usará solo en el service, para evitar conflictos con el userRequest y Response
    private User findUserById(Integer id)
    {
        if (id == null) {
            return null;
        }

        Optional<User> opt = this.userRepository.findById(id);

        if(opt.isPresent())
        {
            return opt.get();
        }
        return null;
    }//fin metodo



    // Buscar por nombre
    public List<UserResponse> findByName(String name){
        return this.convertList(this.userRepository.findByName(name));
    }


    // Login
    public User login(String email, String password)
    {
        return this.userRepository.login(email, password);
    }


        // Guardar usuario
        public UserResponse save(RegisterRequest request){
            if (request.getId() != null) {
                Optional<User> opt = this.userRepository.findById(request.getId());
                // verifica si existe el usuario con ese id
                if (opt.isPresent()) {
                    return null;
                }//fin if
            }

            //guarda la info de userRequest en un user normal
            User user = this.convertToUser(request);

            //guarda el usuario normal
            User savedUser = this.userRepository.save(user);

            // retorna el usuario convertido en Response
            return this.convertToResponse(savedUser);


    }//fin metodo


    // Editar usuario
    public UserResponse editUser(Integer id, UserRequest user)
    {
        User userEdit = this.findUserById(id);

        if (userEdit == null)
        {
            return null;
        }

        userEdit.setName(user.getName());
        userEdit.setMemberQuantity(user.getMemberQuantity());
        userEdit.setEmail(user.getEmail());
        userEdit.setPassword(user.getPassword());

        // Guardar los cambios hechos
        User savedUser = this.userRepository.save(userEdit);


        //se retorna el metodo normal actualizado, convertido a response
        return this.convertToResponse(savedUser);
    }// fin metodo



    // Consumo de agua mensual
    public Double waterConsumptionPerMonth(Integer id)
    {
        User user = this.findUserById(id);

        if (user == null || user.getEcoService() == null)
        {
            return null;
        }

        return user.getEcoService().getLitersOfWaterConsumedPd() * 30;
    }


    // Consumo de luz mensual
    public Double ligthConsumptionPerMonth(Integer id){
        User user = this.findUserById(id);

        if (user == null || user.getEcoService() == null)
        {
            return null;
        }

        return user.getEcoService().getHoursOfLightPd()
                * user.getEcoService().getLightCostPerHour()
                * 30;
    }


    // Consumo de agua anual
    public Double waterConsumptionPerYear(Integer id){
        Double month = this.waterConsumptionPerMonth(id);

        if (month == null)
        {
            return null;
        }

        return month * 12;
    }


    // Consumo de luz anual
    public Double lightConsumptionPerYear(Integer id){
        Double month = this.ligthConsumptionPerMonth(id);

        if (month == null)
        {
            return null;
        }

        return month * 12;
    }




//  Otro método que sea el índice ecológico

    // Eco índice

    public Double ecoIndex(Integer id)
    {
        User user = this.findUserById(id);

        if (user == null || user.getEcoService() == null || user.getDevice() == null)
        {
            return null;
        }

        if (user.getMemberQuantity() == null || user.getMemberQuantity() == 0)
        {
            return null;
        }

        if (user.getDevice().getQuantity() == null)
        {
            return null;
        }

        Double members = user.getMemberQuantity().doubleValue();

        Double waterMediaPerPerson =
                this.waterConsumptionPerMonth(id) / members;

        Double lightMediaPerPerson =
                this.ligthConsumptionPerMonth(id) / members;

        Double devicesMediaPerPerson =
                user.getDevice().getQuantity() / members;

        Double waterPoint = waterMediaPerPerson / 5000;
        Double lightPoint = lightMediaPerPerson / 8000;
        Double devicePoint = devicesMediaPerPerson / 5;

        return 100 * (0.4 * waterPoint
                + 0.4 * lightPoint
                + 0.2 * devicePoint);
    }




    //Este metodo convierte de un User normal a un userResponse
    public UserResponse convertToResponse(User user)
    {
        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getMemberQuantity(), user.getPassword(), user.getEmail());
        return userResponse;
    }//fin metodo



    //Convierte listas normales a listas UserResponse
    public List<UserResponse> convertList(List<User> listUser)
    {
        List<UserResponse> listResponse = new ArrayList<>();

        for(User user1 : listUser)
        {
            listResponse.add(this.convertToResponse(user1));
        }//fin
        return listResponse;
    }//fin metododo



    //Pasa de un UserRequest a un user normal
    private User convertToUser(RegisterRequest request)
    {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setMemberQuantity(request.getMemberQuantity());

        Device device = deviceService.getDevice(request.getDeviceId())
                .orElseThrow(() -> new RuntimeException("Device no existe"));

        EcoService eco = ecoServiceService.getEcoService(request.getEcoServiceId())
                .orElseThrow(() -> new RuntimeException("EcoService no existe"));

        user.setDevice(device);
        user.setEcoService(eco);

        return user;
    }



}//fin clase