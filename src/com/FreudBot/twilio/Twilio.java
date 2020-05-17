package com.FreudBot.twilio;

public class Twilio {
	
	
//	// verification code
//	import com.twilio.Twilio;
//	import com.twilio.rest.verify.v2.Service;
//
//	public class Example {
//	    // Find your Account Sid and Token at twilio.com/console
//	    // DANGER! This is insecure. See http://twil.io/secure
//	    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
//	    public static final String AUTH_TOKEN = "your_auth_token";
//
//	    public static void main(String[] args) {
//	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	        Service service = Service.creator("My First Verify Service").create();
//
//	        System.out.println(service.getSid());
//	    }
//	}
//	
//	import com.twilio.rest.verify.v2.service.Verification;
//
//	public class Example {
//	    // Find your Account Sid and Token at twilio.com/console
//	    // DANGER! This is insecure. See http://twil.io/secure
//	    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
//	    public static final String AUTH_TOKEN = "your_auth_token";
//
//	    public static void main(String[] args) {
//	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	        Verification verification = Verification.creator(
//	                "VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
//	                "+15017122661",
//	                "sms")
//	            .create();
//
//	        System.out.println(verification.getStatus());
//	    }
//	}
//	
//	import com.twilio.Twilio;
//	import com.twilio.rest.verify.v2.service.VerificationCheck;
//
//	public class Example {
//	    // Find your Account Sid and Token at twilio.com/console
//	    // DANGER! This is insecure. See http://twil.io/secure
//	    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
//	    public static final String AUTH_TOKEN = "your_auth_token";
//
//	    public static void main(String[] args) {
//	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	        VerificationCheck verificationCheck = VerificationCheck.creator(
//	                "VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
//	                "123456")
//	            .setTo("+15017122661").create();
//
//	        System.out.println(verificationCheck.getStatus());
//	    }
//	}
//	
//	{
//		  "sid": "VEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
//		  "service_sid": "VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
//		  "account_sid": "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
//		  "to": "+15017122661",
//		  "channel": "sms",
//		  "status": "approved",
//		  "valid": true,
//		  "amount": null,
//		  "payee": null,
//		  "date_created": "2015-07-30T20:00:00Z",
//		  "date_updated": "2015-07-30T20:00:00Z"
//		}
	

}
