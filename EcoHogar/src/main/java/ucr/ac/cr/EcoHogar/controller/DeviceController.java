package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.DTO.DeviceRequest;
import ucr.ac.cr.EcoHogar.model.DTO.DeviceResponse;
import ucr.ac.cr.EcoHogar.service.DeviceService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/EcoHogar")
@CrossOrigin("*")
public class DeviceController
{

    @Autowired
    private DeviceService service;


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(this.service.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        DeviceResponse device = this.service.findById(id);
        if (device == null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dispositivo electronico con el id " +id+ " no se encuentra registrado");
        }
        return ResponseEntity.ok(device);
    }


    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name)
    {
        DeviceResponse device = this.service.findByName(name);
        if (device == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dispositivo con el nombre "+name+"no se encuentra registrado");
        }
        return ResponseEntity.ok(device);
    }


    @PutMapping("/id/{id}")
    public ResponseEntity<?> editDevice(@RequestBody DeviceRequest deviceE, @PathVariable Integer id, BindingResult result){
        if (result.hasErrors())
        {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        }
        DeviceResponse device = this.service.findById(id);
        if (device == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dispositivo con el id " +id+ " no se encuentra registrado");
        }
        return ResponseEntity.ok(this.service.editDevice(id, deviceE));
    }


    @PostMapping("/add")
    public ResponseEntity<?> save(@Validated @RequestBody DeviceRequest deviceR, BindingResult result){
        if (result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        DeviceResponse devicePrue = this.service.findByName(deviceR.getName());
        if (devicePrue != null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El dispositivo "+deviceR.getName()+" ya se encuentra registrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(deviceR));
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable Integer id)
    {
        DeviceResponse device = this.service.findById(id);
        if (device == null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dispositivo electronico con el id " +id+ " no se encuentra registrado");
        }
        this.service.deleteDevice(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
