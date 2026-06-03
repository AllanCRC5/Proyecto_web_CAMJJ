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


//    Agregar
     public UserLoginDto saveUserDto(User user)
     {
         Optional<User> opt=this.userRepository.findById(user.getId());
         if(opt.isPresent()){
             return null;
         }
         return this.convertUserDTO(this.userRepository.save(user));
     }//fin metodo


     // Metodo save sin login
    public User saveUser(User user)
    {
        Optional<User> opt=this.userRepository.findById(user.getId());
        if(opt.isPresent()){
            return null;
        }
        return this.userRepository.save(user);
    }//fin metodo






//     Encontrar

     public List<UserLoginDto> finAllDto()
     {
         return this.convertListDTO(this.userRepository.findAll());
     }//fin metodo


     public UserLoginDto findByIdDto(Integer id)
     {
         Optional<User> optional=this.userRepository.findById(id);
         if (optional.isPresent())
         {
             return this.convertUserDTO(optional.get());
         }
         return null;
     }//fin metodo


    // buscar sin DTO
    public List<User> finAll()
    {
        return this.userRepository.findAll();
    }//fin metodo


    public User findByID(Integer id)
    {
        Optional<User> optional=this.userRepository.findById(id);
        if (optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }//fin metodo








//     Borrar

     public void deleteUser(Integer id)
     {
         this.userRepository.deleteById(id);
     }//fin metodo





//     Editar

    public UserLoginDto editUserDto(Integer id, UserLoginDto userEdit)
    {
        Optional<User> userOp=this.userRepository.findById(id);
        if (userOp.isPresent())
        {
            User user=userOp.get();

            user=userEdit;

            return this.convertUserDTO(this.userRepository.save(user));
        }
        return null;
    }//fin metodo


    //editar sin DTO
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






//
    public UserLoginDto convertUserDTO(User user)
    {
        UserLoginDto dto=new UserLoginDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }//fin metodo


    public List<UserLoginDto> convertListDTO(List<User> listUser)
    {
        List<UserLoginDto> listDTO = new ArrayList<>();
        for (User user : listUser) {
            listDTO.add(this.convertUserDTO(user));
        }
        return listDTO;
    }//fin metodo



    public List<UserLoginDto> findByNameDto(String name)
    {
        return this.convertListDTO(this.userRepository.findByName(name));
    }//fin metodo




    // findByName sin DTO
    public List<User> findByName(String name)
    {
        return this.userRepository.findByName(name);
    }//fin metodo



    public List<User> findAllByOrderByName()
    {
        return this.userRepository.findAllByOrderByName();
    }//fin metodo



}//fin clase
