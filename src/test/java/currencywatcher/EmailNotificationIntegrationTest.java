package currencywatcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
//		(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CurrencyWatcherApplication.class})
//@TestPropertySource(locations="classpath:application-test.properties")
public class EmailNotificationIntegrationTest {
	
	@Autowired private EmailNotification emaiNotification;
	@Autowired UserDetailsRepository userDetailsRepository;
	
	@Rule
	public SmtpServerRule smtpServerRule = new SmtpServerRule (2525);
	
	@Test
	public void testEmailNotification() throws MessagingException, IOException {
//		UserDetails userDetails = new UserDetails();
//		userDetails.setEmailAddress("olanipekun_akin@yahoo.co.uk");
//		userDetails.setAboveBelow("above");
//		userDetails.setPrice(10.01);
//		userDetails.setEmailSent("No Email Sent");

		String emailSent = "No Email Sent";
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Ola");
		userDetails.setLastName("AKin");
		userDetails.setEmailAddress("olanipekun_akin@yahoo.co.uk");
		userDetails.setCurrenciesType("dash");
		userDetails.setPrice(10.01);
		userDetails.setCurrencyChoice("bitcoin");
		userDetails.setAboveBelow("above");
		userDetails.setEmailSent(emailSent);
		userDetailsRepository.save(userDetails);

		String a = userDetails.getEmailSent();
		emaiNotification.sendEmail(userDetails);

		MimeMessage[] receivedMessages = smtpServerRule.getMessages();
		assertEquals(1, receivedMessages.length );
		
	    MimeMessage current = receivedMessages[0];
	    
	    String subject = "CryptoCurrency Price Notification";
	    String content = " The price that was chosen by you is " + userDetails.getAboveBelow() + " " + userDetails.getPrice() + ".";
	    
//	    assertEquals(subject, current.getSubject() );
//		assertThat( subject ).isEqualTo( current.getSubject() );
//	    assertEquals(userDetails.getEmailAddress(), current.getAllRecipients()[0].toString() );
//	    assertTrue(String.valueOf( current.getContent() ).contains(content)  );

	}
}
