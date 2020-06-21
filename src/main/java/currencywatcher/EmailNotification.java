package currencywatcher;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification {
	
	private JavaMailSender javaMailSender;
	
	public EmailNotification( JavaMailSender javaMailSender ) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(UserDetails userDetails) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(userDetails.getEmailAddress()); 
        message.setFrom("olamoiakin@gmail.com");
        message.setSubject( "CryptoCurrency Price Notification " ); 
        message.setText(" The price that was chosen by you is " + userDetails.getAboveBelow() + " " + userDetails.getPrice() + ".");
       
        javaMailSender.send(message);
	}
}
