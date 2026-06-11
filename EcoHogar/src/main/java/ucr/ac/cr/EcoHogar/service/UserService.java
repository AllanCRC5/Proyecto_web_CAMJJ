package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceService deviceService;


    // Buscar todos
    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }


    // Buscar por ID
    public User findByID(Integer id)
    {
        Optional<User> opt = this.userRepository.findById(id);

        if (opt.isPresent())
        {
            return opt.get();
        }

        return null;
    }


    // Buscar por nombre
    public List<User> findByName(String name)
    {
        return this.userRepository.findByName(name);
    }


    // Login
    public User login(String email, String password)
    {
        return this.userRepository.login(email, password);
    }


    // Guardar usuario
    public User save(User user)
    {
        //verificar que el id no venga vacio
        if(user.getId() == null)
        {
            return null;
        }

        Optional<User> opt = this.userRepository.findById(user.getId());

        // verifica si existe el usuario con ese id
        if(opt.isPresent())
        {
            return null;
        }

        return this.userRepository.save(user);

    }//fin metodo

    // Editar usuario
    public User editUser(Integer id, User user)
    {
        User userEdit = this.findByID(id);

        if (userEdit == null)
        {
            return null;
        }

        userEdit.setName(user.getName());
        userEdit.setMemberQuantity(user.getMemberQuantity());
        userEdit.setEmail(user.getEmail());
        userEdit.setPassword(user.getPassword());
        userEdit.setDevice(user.getDevice());
        userEdit.setEcoService(user.getEcoService());

        return this.userRepository.save(userEdit);
    }


    // Consumo de agua mensual
    public Double waterConsumptionPerMonth(Integer id)
    {
        User user = this.findByID(id);

        if (user == null || user.getEcoService() == null)
        {
            return null;
        }

        return user.getEcoService().getLitersOfWaterConsumedPd() * 30;
    }


    // Consumo de luz mensual
    public Double ligthConsumptionPerMonth(Integer id)
    {
        User user = this.findByID(id);

        if (user == null || user.getEcoService() == null)
        {
            return null;
        }

        return user.getEcoService().getHoursOfLightPd()
                * user.getEcoService().getLightCostPerHour()
                * 30;
    }


    // Consumo de agua anual
    public Double waterConsumptionPerYear(Integer id)
    {
        Double month = this.waterConsumptionPerMonth(id);

        if (month == null)
        {
            return null;
        }

        return month * 12;
    }


    // Consumo de luz anual
    public Double lightConsumptionPerYear(Integer id)
    {
        Double month = this.ligthConsumptionPerMonth(id);

        if (month == null)
        {
            return null;
        }

        return month * 12;
    }


    // Eco índice
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
    }
}