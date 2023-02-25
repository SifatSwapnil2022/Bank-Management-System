public class Captcha implements Methods {
	
	public String getcaptchaValue() {
	
	String captchaString = "ABCDEFGHIJKLMNOPQRSTWUVXYZabcdefghijklmnopqrstwuvxyz1234567890";
	String captcha = "";
	for(int i=0; i<5;i++) {
		int index = (int)(Math.random()*captchaString.length()); 
		//charAt method returns the character at the specified index in a string
		captcha=captcha+captchaString.charAt(index);
	}
	return captcha;
	
	
}

	
}