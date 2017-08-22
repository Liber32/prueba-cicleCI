package authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import authentication.User;

@Controller    
@RequestMapping(path="/authentication") 
public class MainController {
	@Autowired 	           
	private UserRepository userRepository;
	
	@RequestMapping(value="/login", method=RequestMethod.GET) 
	public @ResponseBody w4sResponse login (@RequestParam String email) {
		
		List<User> n = userRepository.findByEmail(email);
		
		w4sResponse response= new w4sResponse();
		
		if(n.isEmpty())
		{
			response.setCode("501");	        
			response.setType("user");
			return response;
			
		}else
		{
			response.setCode("200");	        
			response.setType("user");
			response.setEntity(n.get(0));
			return response;
			
			
			
		}
	    	
	}

	
	
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public @ResponseBody w4sResponse register (@RequestBody User user) {
		 	
		User newUser=userRepository.save(user);
		
		w4sResponse response= new w4sResponse();
		
		if(newUser==null)
		{
			response.setCode("501");	        
			response.setType("user");
			return response;
			
		}else
		{
			response.setCode("200");	        
			response.setType("user");
			response.setEntity(newUser);
			return response;
			
			
			
		}
	    	
	}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
