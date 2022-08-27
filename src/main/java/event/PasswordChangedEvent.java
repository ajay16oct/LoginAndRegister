package event;

import org.springframework.context.ApplicationEvent;

import com.loginAndRegister.LoginAndRegister.Entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class PasswordChangedEvent extends ApplicationEvent{

	private User user;
	
	public PasswordChangedEvent(Object source, User user) {
		super(source);
		// TODO Auto-generated constructor stub
		
		this.user=user;
	}

	private static final long serialVersionUID = 1L;

}
