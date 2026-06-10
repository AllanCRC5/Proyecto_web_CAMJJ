package ucr.ac.cr.EcoHogar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.EcoHogar.model.DTO.UserLoginDto;
import ucr.ac.cr.EcoHogar.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>
{
    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User login(@Param("email") String email,
               @Param("password") String password);

    @Query("SELECT u FROM User u Where u.email = :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    List<User> findAllByOrderByName();

    Optional<User> findById(Integer id);
}//fin clase
