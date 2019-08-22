package tesi.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserViewModel {
	
	private String firstname;
	private String lastname; 
	private String country;
	private int age;
}
