/**
 * 
 */
package hello.services;

import hello.domain.AppData;

/**
 * @author gkovan@us.ibm.com
 *
 */
public interface WatsonToneAnalyzer {
	public String analyzeTone(AppData appData);
}
