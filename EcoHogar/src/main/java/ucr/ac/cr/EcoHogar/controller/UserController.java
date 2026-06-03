package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.DTO.UserLoginDto;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/family")
public class UserController
{
    @Autowired
    private UserService userService;




    //Find All
    @GetMapping
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(this.userService.finAll());
    }//fin metodo




    //findById
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        User user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(user);
    }//Fin metodo


    //findByName
    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name)
    {
        if(this.userService.findByName(name).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El nombre no se encuentra registrado");
        }//fin if
        return ResponseEntity.ok(this.userService.findByName(name));
    }//fin metodo




    @GetMapping("/id/DTO/{id}")
    public ResponseEntity<?> findByIdDto(@PathVariable Integer id)
    {
        UserLoginDto user = this.userService.findByIdDto(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(user);
    }//Fin metodo


    //findByName
    @GetMapping("/name/DTO/{name}")
    public ResponseEntity<?> findByNameDto(@PathVariable String name)
    {
        if(this.userService.findByNameDto(name).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El nombre no se encuentra registrado");
        }//fin if
        return ResponseEntity.ok(this.userService.findByNameDto(name));
    }//fin metodo







    // edith
    @PutMapping("/id/{id}")
    public ResponseEntity<?>edit(@Validated @PathVariable Integer id, @RequestBody User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        User userEd = this.userService.findByID(user.getId());

        if(userEd == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se encuentra el usuario con ese id");
        }//fin if
        return ResponseEntity.ok(this.userService.editUser(id, user));
    }//fin metopdo



    //edit con DTO
    @PutMapping("/id/DTO/{id}")
    public ResponseEntity<?>editDto(@Validated @PathVariable Integer id, @RequestBody UserLoginDto userLoginDto, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        UserLoginDto userEdDto = this.userService.findByIdDto(userLoginDto.getId());

        if(userEdDto == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se encuentra el usuario con ese id");
        }//fin if
        return ResponseEntity.ok(this.userService.editUserDto(id, userLoginDto));
    }//fin metopdo








    //save
    @PostMapping("/save/DTO")
    public  ResponseEntity<?> saveUserDto(@Validated @RequestBody User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        UserLoginDto dto=this.userService.saveUserDto(user);
        if (dto==null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID: "+user.getId()+ "ya esta registrado.");
        }//fin if
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }//fin metodo




    //save DTO
    @PostMapping("/save")
    public  ResponseEntity<?> saveUser(@Validated @RequestBody User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        User dto=this.userService.saveUser(user);
        if (dto==null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID: "+user.getId()+ "ya esta registrado.");
        }//fin if
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }//fin metodo





}//fin clase
