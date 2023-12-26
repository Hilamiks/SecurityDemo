package security.tutorial.lesson2.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.tutorial.lesson2.entities.User;
import security.tutorial.lesson2.repositories.UserRepository;
import security.tutorial.lesson2.security.SecurityUser;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public JpaUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u = userRepository.findUserByUsername(username);
		return u.map(SecurityUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
