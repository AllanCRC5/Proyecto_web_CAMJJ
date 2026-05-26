package ucr.ac.cr.EcoHogar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.EcoHogar.model.Device;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> findAll ();

    Optional<Device> findByName (String name);

}
