package com.iocl.Dispatch_Portal_Application.ServiceLayer;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	
	@Autowired
    private JavaMailSender mailSender;

 public void sendEmail(String to, String subject, String text, byte[] attachment) {

        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // true indicates multipart
            
        //    helper.setFrom("kilugusai2001@gmail.com");

            helper.setTo(to);

            helper.setSubject(subject);

            helper.setText(text, true); // true indicates HTML

            // Add PDF attachment

            if (attachment != null) {

                ByteArrayResource pdfResource = new ByteArrayResource(attachment);

                helper.addAttachment("Parcel_Details.pdf", pdfResource);

            }

            mailSender.send(mimeMessage);

            System.out.println("Email sent successfully to " + to);

        } catch (Exception e) {

            System.err.println("Failed to send email to " + to);

            e.printStackTrace();

        }
}
}
