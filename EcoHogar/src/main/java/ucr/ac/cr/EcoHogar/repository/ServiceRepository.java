package ucr.ac.cr.EcoHogar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.EcoHogar.model.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service>findAll();
    Service findByName(String name);//Aqui el problema, no está bien escrita la consulta
}
