/**
 * 
 */
package hello.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.DocumentAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

import hello.domain.AppData;

/**
 * @author gkovan@us.ibm.com
 *
 */
@Service
public class WatsonToneAnalyzerImpl implements WatsonToneAnalyzer {
	

	

	/* (non-Javadoc)
	 * @see application.springboot.web.services.WatsonToneAnalyzerInterface#analyzeTone(java.lang.String)
	 */
	@Override
	public String analyzeTone(AppData appData) {
		
		String sentence = appData.getSentence();
		final String VERSION_DATE = "2016-05-19";
		ToneAnalyzer service = new ToneAnalyzer(VERSION_DATE);
		service.setUsernameAndPassword("43233b68-ae7e-4804-b7b5-3302597d1834", "g8a4Lt6g5jrT");

//		String text = "I know the times are difficult! Our sales have been "
//				+ "disappointing for the past three quarters for our data analytics "
//				+ "product suite. We have a competitive data analytics product "
//				+ "suite in the industry. But we need to do our job selling it! "
//				+ "We need to acknowledge and fix our sales challenges. "
//				+ "We can’t blame the economy for our lack of execution! "
//				+ "We are missing critical sales opportunities. "
//				+ "Our product is in no way inferior to the competitor products. "
//				+ "Our clients are hungry for analytical tools to improve their "
//				+ "business outcomes. Economy has nothing to do with it.";

		// Call the service and get the tone
//works		ToneOptions toneOptions = new ToneOptions.Builder().html(sentence).build();
		ToneOptions toneOptions = new ToneOptions.Builder().sentences(false).text(sentence).build();

		ToneAnalysis tone = service.tone(toneOptions).execute();
		System.out.println(tone);
		appData.setToneAnalysis(tone);
        identifyPrimaryTone(appData);
		return tone.toString();
	}
	
	private void identifyPrimaryTone(AppData appData) {
		
		String primaryToneName = "";
		Double primaryToneScore = 0.0;
		List<ToneScore> toneScoreList = null;
		
		ToneAnalysis tone = appData.getToneAnalysis();
		DocumentAnalysis da = tone.getDocumentTone();	

		toneScoreList = da.getToneCategories().get(0).getTones();
		appData.setToneScoreList(toneScoreList);
		System.out.println("Size of ToneScore List is: " + toneScoreList.size());
		
		
		for (ToneScore ts : toneScoreList ) {
			System.out.println("GGG");
			System.out.println(ts.toString());
			if (ts.getScore() > primaryToneScore)  {
			   primaryToneScore = ts.getScore();
			   primaryToneName = ts.getToneName();
			}
		}
		appData.setPrimaryToneName(primaryToneName);
		appData.setPrimaryToneScore(primaryToneScore);
	}
}
