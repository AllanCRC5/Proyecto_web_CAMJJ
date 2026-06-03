package ucr.ac.cr.EcoHogar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.EcoHogar.model.DTO.UserLoginDto;
import ucr.ac.cr.EcoHogar.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>
{
    List<User> findByName(String name);

    User findByEmailAndPassword(String email, String password);

    List<User> findAllByOrderByName();

    Optional<User> findById(Integer id);
}
