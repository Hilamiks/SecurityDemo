package security.tutorial.lesson2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import security.tutorial.lesson2.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

	@Query(
			"SELECT u FROM User u WHERE u.username = :username"
	)
	Optional<User> findUserByUsername(String username);
}
