package authentication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String fullName;

    private String email;
    
    
    private String phone_Number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getphoneNumber() {
		return phone_Number;
	}

	public void setphoneNumber(String name) {
		this.phone_Number = name;
	}
	
	public String getfullName() {
		return fullName;
	}

	public void setfullName(String name) {
		this.fullName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

