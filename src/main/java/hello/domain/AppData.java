/**
 * 
 */
package hello.domain;

import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

/**
 * @author gkovan@us.ibm.com
 *
 */
public class AppData {
	// input
	private String phonenumber;

	private String sentence;

	// output
	private ToneAnalysis toneAnalysis;
	private List<ToneScore> toneScoreList = null;
	private String primaryToneName = "";
	private Double primaryToneScore = 0.0;
	private String smsMessageToSend = "";

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param phonenumber
	 *            the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @return the sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * @param sentence
	 *            the sentence to set
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	/**
	 * @return the toneAnalysis
	 */
	public ToneAnalysis getToneAnalysis() {
		return toneAnalysis;
	}

	/**
	 * @param toneAnalysis
	 *            the toneAnalysis to set
	 */
	public void setToneAnalysis(ToneAnalysis toneAnalysis) {
		this.toneAnalysis = toneAnalysis;
	}

	/**
	 * @return the toneScoreList
	 */
	public List<ToneScore> getToneScoreList() {
		return toneScoreList;
	}

	/**
	 * @param toneScoreList
	 *            the toneScoreList to set
	 */
	public void setToneScoreList(List<ToneScore> toneScoreList) {
		this.toneScoreList = toneScoreList;
	}

	/**
	 * @return the primaryToneName
	 */
	public String getPrimaryToneName() {
		return primaryToneName;
	}

	/**
	 * @param primaryToneName
	 *            the primaryToneName to set
	 */
	public void setPrimaryToneName(String primaryToneName) {
		this.primaryToneName = primaryToneName;
	}

	/**
	 * @return the primaryToneScore
	 */
	public Double getPrimaryToneScore() {
		return primaryToneScore;
	}

	/**
	 * @param primaryToneScore
	 *            the primaryToneScore to set
	 */
	public void setPrimaryToneScore(Double primaryToneScore) {
		this.primaryToneScore = primaryToneScore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppData [phonenumber=" + phonenumber + ", sentence=" + sentence + ", toneAnalysis=" + toneAnalysis
				+ ", toneScoreList=" + toneScoreList + ", primaryToneName=" + primaryToneName + ", primaryToneScore="
				+ primaryToneScore + "]";
	}

	/**
	 * @return the smsMessageToSend
	 */
	public String getSmsMessageToSend() {
		return smsMessageToSend;
	}

	/**
	 * @param smsMessageToSend the smsMessageToSend to set
	 */
	public void setSmsMessageToSend(String smsMessageToSend) {
		this.smsMessageToSend = smsMessageToSend;
	}

}
