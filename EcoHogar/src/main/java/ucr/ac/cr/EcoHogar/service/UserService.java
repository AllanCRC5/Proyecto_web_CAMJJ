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
            user=userEdi+t;
            return this.userRepository.save(user);
        }
        return null;
    }//fin metodo

    //Metodo save
    public User save(User user)
    {
        Optional<User> opt=this.userRepository.findById(user.getId());
        if(opt.isPresent()){
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
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }//fin metodo

//metodo convertir lista a DTO
    public List<UserLoginDto> convertListDTO(List<User> listUser)
    {
        List<UserLoginDto> listDTO = new ArrayList<>();
        for (User user : listUser) {
            listDTO.add(this.convertUserDTO(user));
        }
        return listDTO;
    }//fin metodo

    public List<User> findAllByOrderByName()
    {
        return this.userRepository.findAllByOrderByName();
    }//fin metodo



}//fin clase
