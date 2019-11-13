package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devglan.dao.UserDao;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public UserDto update(UserDto userDto) {
		User user = findById(userDto.getId());
		if (user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			userDao.save(user);
		}
		return userDto;
	}

	@Override
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setMobileno(user.getMobileno());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setId(user.getId());

		return userDao.save(newUser);
	}

	/*
	 * private JavaMailSender javaMailSender;
	 * 
	 * @Autowired public void MailService(JavaMailSender javaMailSender) {
	 * this.javaMailSender = javaMailSender; }
	 */

	/*
	 * public void sendEmail(User user) throws MailException {
	 * 
	 * SimpleMailMessage mail = new SimpleMailMessage();
	 * mail.setTo(user.getEmail()); mail.setSubject("Testing Mail API");
	 * mail.setText("Hurray ! You have done that dude...");
	 * javaMailSender.send(mail); }
	 * 
	 * 
	 * public void sendEmailWithAttachment(User user) throws MailException,
	 * MessagingException {
	 * 
	 * MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	 * 
	 * MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	 * 
	 * helper.setTo(user.getEmail());
	 * helper.setSubject("Testing Mail API with Attachment");
	 * helper.setText("Please find the attached document below.");
	 * 
	 * ClassPathResource classPathResource = new
	 * ClassPathResource("Attachment.pdf");
	 * helper.addAttachment(classPathResource.getFilename(), classPathResource);
	 * 
	 * javaMailSender.send(mimeMessage); }
	 */
	
}
