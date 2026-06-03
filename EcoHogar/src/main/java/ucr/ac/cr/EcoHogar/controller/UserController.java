package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/family")
public class UserController
{
    @Autowired
    private UserService userService;

    //Obtener todos-funcionaa
    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        return ResponseEntity.ok(this.userService.findAll());
    }//fin metodo

    //Obtener por id-funciona
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        User user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok(user);
    }//Fin metodo


    //findByName, se revisa después
//    @GetMapping("/name/{name}/{id}")
//    public ResponseEntity<?> findByName(@PathVariable String name, Integer id)
//    {
//        User user=this.userService.findByID(id);
//        if(user==null)
//        {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El nombre no se encuentra registrado");
//        }//fin if
//        return ResponseEntity.ok(this.userService.findByName(name));
//    }//fin metodo

    //Editar-funciona
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
    }//fin metodo

    //Guardar usuario
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

        User dto=this.userService.save(user);
        if (dto==null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID: "+user.getId()+ "ya esta registrado.");
        }//fin if
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }//fin metodo
}//fin clase
