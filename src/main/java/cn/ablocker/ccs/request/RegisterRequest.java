package cn.ablocker.ccs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String username;
	
	private String password;
	
	private float longitude;
	
	private float latitude;
	
	private String soft;
	
	private String status;
}
