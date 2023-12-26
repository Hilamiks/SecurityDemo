package security.tutorial.lesson2.security;

import org.springframework.security.core.GrantedAuthority;
import security.tutorial.lesson2.entities.Authority;

public class SecurityAuthority implements GrantedAuthority {

	private final Authority authority;

	public SecurityAuthority(Authority authority) {
		this.authority=authority;
	}

	@Override
	public String getAuthority() {
		return authority.getName();
	}
}
