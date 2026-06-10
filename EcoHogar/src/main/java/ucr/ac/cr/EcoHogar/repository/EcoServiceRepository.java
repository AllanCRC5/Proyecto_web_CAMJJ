package ucr.ac.cr.EcoHogar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.EcoHogar.model.EcoService;

import java.util.List;
import java.util.Optional;

public interface EcoServiceRepository extends JpaRepository<EcoService, Integer>
{
    List<EcoService> findAll();
    List<EcoService> findByName(String name);//Aqui el problema, no está bien escrita la consulta
    Optional<EcoService> findById(Integer id);
}//fin clase
