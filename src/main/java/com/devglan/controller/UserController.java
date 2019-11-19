package com.devglan.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.ApiResponse;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * String to[] = {"a@gmail.com"} //Mail id you want to send; InternetAddress[]
	 * address = new InternetAddress[to.length]; for(int i =0; i< to.length; i++) {
	 * address[i] = new InternetAddress(to[i]); }
	 * 
	 * msg.setRecipients(Message.RecipientType.TO, address);
	 * 
	 */

	@PostMapping("/save")

	public ApiResponse<User> saveUser(@RequestBody UserDto user) throws InterruptedException {
		System.out.println("save");
		int otp = ch();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("your secret otp is :" + otp);
		message.setText("thanks for registering with us HAVE A GREAT DAY.....");
		javaMailSender.send(message);

		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));
	}

	/*
	 * private static final Integer EXPIRE_MINS = 5; private LoadingCache<String,
	 * Integer> otpCache;
	 * 
	 * public int OtpService() { otpCache =
	 * CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
	 * .build(new CacheLoader<String, Integer>() { public Integer load(String key) {
	 * return 0; } }); return 1; }
	 */
	@Cacheable(value = "UserInfo")
	@Scheduled(initialDelay = 3000, fixedDelay = 3000)
	public Integer ch() throws InterruptedException {
		long time = 2000;
		Thread.sleep(time);
		// if (time < 3000) {
		int otp1 = generateOTP();
		// Thread.sleep(time);
		return otp1;
		// } else {
		// return 0;
		// }

	}

	public int generateOTP() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return otp;
	}
	/*
	 * public void verifyOTP() throws InterruptedException { User user = new User();
	 * String[] email = user.getEmail(); Integer ch = ch();
	 * 
	 * }
	 */

	@PostMapping("/save1")
	public ApiResponse<User> saveUser1(@RequestBody UserDto user) throws MessagingException, IOException {
		// MimeMessage message = new
		// MimeMessage(javaMailSender.createMimeMessage());//.createMimeMessage();

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		try {
			helper.setTo(user.getEmail());
			helper.setText("helooo how are you?");
			helper.setSubject("Nothing?????");
			ClassPathResource file = new ClassPathResource("image/ajay1.png");
			// Resource r = new ClassPathResource("image/ajay1.png");
			// File file = r.getFile();
			// helper.addAttachment("ajay.jpg", new File("E:\\ajay1.png"));
			helper.addAttachment("image/ajay1.png", file);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(message);
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));
	}

	@GetMapping("/getAll")
	public ApiResponse<List<User>> listUser() {
		System.out.println("getAll");
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", userService.findAll());
	}

	@GetMapping("/{id}")
	public ApiResponse<User> getOne(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", userService.findById(id));
	}

	@PutMapping("/{id}")
	public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.update(userDto));
	}

	@DeleteMapping("/{id}")
	public ApiResponse<Void> delete(@PathVariable int id) {
		userService.delete(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
	}

}
