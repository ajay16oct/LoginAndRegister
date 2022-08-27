package event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;
import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Service.ValidationTokenService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

	private User user;
	private String url;

	public RegistrationCompleteEvent(User user, String url) {
		super(user);
		// TODO Auto-generated constructor stub

		this.user = user;
		this.url = url;

	}

}
