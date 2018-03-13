/**
 * 
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.domain.AppData;
import hello.services.TwilioSendSMSMessage;
import hello.services.WatsonToneAnalyzer;

/**
 * @author gkovan@us.ibm.com
 *
 */

@Controller
public class MyController {

	@Autowired
	WatsonToneAnalyzer toneAnalyzer;
	
	@Autowired
	TwilioSendSMSMessage sendSMS;
	

    @GetMapping("/whatsyourtone")
    public String whatsYourToneForm(Model model) {
    	    model.addAttribute("appData", new AppData());
        return "whatsyourtone";
    }
	
    @PostMapping("/whatsyourtone")
    public String whatsYourToneSubmit(@ModelAttribute AppData appData) {
		System.out.println(appData.getPhonenumber());
		System.out.println(appData.getSentence());
		toneAnalyzer.analyzeTone(appData);
		sendSMS.sendSMSMessage(appData);

        return "whatsyourtone-result";
    }
	
    
	@GetMapping("/whatsyourtonerest")
	public AppData elianasToneAnalyzer(@RequestParam(value="phonenumber", required=true) String phonenumber, @RequestParam(value="sentence", required=true) String sentence) {
		System.out.println(phonenumber);
		System.out.println(sentence);

		AppData appData = new AppData();
		appData.setPhonenumber(phonenumber);
		appData.setSentence(sentence);
		toneAnalyzer.analyzeTone(appData);
		sendSMS.sendSMSMessage(appData);
		return appData;
		//return phonenumber + sentence + toneAnalyzer.analyzeTone(sentence);
		
	}
	
	
	@GetMapping("/test")
	public String test() {
		return "TEST";
	}

}
