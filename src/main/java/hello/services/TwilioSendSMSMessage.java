/**
 * 
 */
package hello.services;

import hello.domain.AppData;

/**
 * @author gkovan@us.ibm.com
 *
 */
public interface TwilioSendSMSMessage {
	public String sendSMSMessage(AppData appData);
}
