/**
 * 
 */
package hello.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import hello.domain.AppData;

/**
 * @author gkovan@us.ibm.com
 *
 */
@Service
public class TwilioSendSMSMessageImpl implements TwilioSendSMSMessage {
	
	  private static final String ACCOUNT_SID = "AC5d1f13f93c5147912f5503bf93b3f4ec";
	  private static final String AUTH_TOKEN = "21444546ebc4b6cb7a082c5e359fa24a";
	  private static HashMap<String, String> smsMessages = new HashMap<String, String>();

	/* (non-Javadoc)
	 * @see application.springboot.web.services.TwilioSendSMSMessage#sendSMSMessage(java.lang.String)
	 */
	  
	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		smsMessages.put("Joy", "I am happy you are joyful. Being joyful is a big mitzvah");
		smsMessages.put("Sadness", "It is too bad you are sad. Perhaps a funny joke will cheer you up.");
		smsMessages.put("Fear", "I sense you have fear.  Davening should help with that.");
		smsMessages.put("Anger", "I sense you are angry.  Pirkei Avot says a strong person is one who can control his anger.");
		smsMessages.put("Disgust", "Something is really disturbing you.  You should stay away from whatever it is");
	}
	
	@Override
	public String sendSMSMessage(AppData appData) {
		
		String toPhoneNumber = appData.getPhonenumber();
		
        if (toPhoneNumber == null) {
        	   appData.setPhonenumber(" < Phone number is null >");
        	   return appData.getPhonenumber();
        }
        
        if (toPhoneNumber.equals("")) {
        	   appData.setPhonenumber(" < Phone mumber is empty >");
        	   return appData.getPhonenumber();
        }
		
        if (toPhoneNumber.length() != 10 ) {
        	    appData.setPhonenumber(" < Phone number is not 10 digits >");
        	    return appData.getPhonenumber();
        }
        	   

		// first phone mumber receives the message, the second number is the sender.
		Message message = Message.creator(new PhoneNumber("+1" + toPhoneNumber),
		        new PhoneNumber("+12013471339"), 
		        smsMessages.get(appData.getPrimaryToneName())).create();
		
		appData.setSmsMessageToSend(smsMessages.get(appData.getPrimaryToneName()));
		return message.getSid();
	}
}
