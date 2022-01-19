package com.expert_republic.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LoginResponse {

	/*@NotNull(message = "jwt is mandatory")
	@NotBlank(message = "jwt is mandatory")
	@NotEmpty(message = "jwt is mandatory")*/
	private Map<String, String> payload;

	public LoginResponse(Map<String, String> payLoad) {
		this.payload = payLoad;
	}
}
