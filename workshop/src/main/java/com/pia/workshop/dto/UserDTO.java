
package com.pia.workshop.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {
	@NotNull(message = "name is mandatory!!")
	private String name;
	@NotNull(message = "surname is mandatory!!")
	private String surname;
	@NotNull(message = "username is mandatory!!")
	private String username;
}
