package ucr.ac.cr.EcoHogar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.EcoHogar.model.User;

import java.util.List;

@Repository
public interface FamilyRepository  extends JpaRepository <User, Integer>{
    List<User> findByName(String name);


    User findByEmailAndPassword(String email, String password);

    List<User> findAllByOrderByName();
}
