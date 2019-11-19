/*
 * package com.devglan.controller;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.devglan.service.impl.MyEmailService; import
 * com.devglan.service.impl.OtpService;
 */
/*
 * @RestController public class OtpController {
 * 
 * @Autowired public OtpService otpService;
 * 
 * @Autowired public MyEmailService myEmailService;
 * 
 * @GetMapping("/generateOtp") public String generateOtp(){
 * 
 * int otp = otpService.generateOTP(null); System.out.println("OTP : "+otp);
 * //Generate The Template to send OTP
 * 
 * Map<String,String> replacements = new HashMap<String,String>();
 * //replacements.put("user", username); //replacements.put("otpnum",
 * String.valueOf(otp)); //String message = template.getTemplate(replacements);
 * myEmailService.sendOtpMessage("shrisowdhaman@gmail.com", "OTP -SpringBoot",
 * null); return "otppage"; }
 * 
 * @RequestMapping(value ="/validateOtp", method = RequestMethod.GET)
 * public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum){
 * final String SUCCESS = "Entered Otp is valid"; final String FAIL =
 * "Entered Otp is NOT valid. Please Retry!"; Authentication auth =
 * SecurityContextHolder.getContext().getAuthentication(); String username =
 * auth.getName(); logger.info(" Otp Number : "+otpnum); //Validate the Otp
 * if(otpnum >= 0){ int serverOtp = otpService.getOtp(username); if(serverOtp >
 * 0){ if(otpnum == serverOtp){ otpService.clearOTP(username); return
 * ("Entered Otp is valid"); }else{ return SUCCESS; } }else { return FAIL; }
 * }else { return FAIL; } }
 * 
 * }
 */