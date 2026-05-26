package ucr.ac.cr.EcoHogar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.EcoHogar.model.DTO.UserDTO;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.repository.FamilyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;


//    Agregar

     public UserDTO saveUser(User user){
         Optional<User> opt=this.familyRepository.findById(user.getIdFamily());
         if(opt.isPresent()){
             return null;
         }
         return this.convertUserDTO(this.familyRepository.save(user));
     }

//     Encontrar

     public List<UserDTO> finAll(){
         return this.convertListDTO(this.familyRepository.findAll());
     }

     public UserDTO findByIDFamily(Integer id){
         Optional<User> optional=this.familyRepository.findById(id);
         if (optional.isPresent()){
             return this.convertUserDTO(optional.get());
         }
         return null;
     }

//     Borrar

     public void deleteUser(Integer id){
         this.familyRepository.deleteById(id);
     }


//     Editar

        public UserDTO editUser(Integer id, User userEdit){
         Optional<User> userOp=this.familyRepository.findById(id);
         if (userOp.isPresent()){
             User user=userOp.get();
             user=userEdit;
             return this.convertUserDTO(this.familyRepository.save(user));
           }
         return null;
        }


    public UserDTO convertUserDTO(User user){
        UserDTO dto=new UserDTO();
        dto.setId(user.getIdFamily());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }

    public List<UserDTO> convertListDTO(List<User> listUser) {
        List<UserDTO> listDTO = new ArrayList<>();
        for (User user : listUser) {
            listDTO.add(this.convertUserDTO(user));
        }
        return listDTO;
    }

        public List<UserDTO> findByName(String name){
         return this.convertListDTO(this.familyRepository.findByName(name));
        }

    public List<User> findAllByOrderByName()
    {

        return this.familyRepository.findAllByOrderByName();
    }




}
