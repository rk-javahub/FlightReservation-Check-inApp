package com.rohit.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



/**
 * Class for Email sending functionality.
 * 
 * @author Rohit
 * @version 1.0
 * 
 *
 */
@Component
public class EmailUtil {

	@Autowired
	JavaMailSender sender;

	Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	/**
	 * Method to send Email which contain ticket in PDF form as an attachment.
	 * 
	 * 
	 * @param toAddress Email Address of receiver.
	 * @param filePath  Path of File Attachment.
	 * 
	 */
	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("Inside sendItinerary");
		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary for your Flight");
			mimeMessageHelper.setText("Please find your itinerary attached");
			mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary " + e);
		}

	}

}
