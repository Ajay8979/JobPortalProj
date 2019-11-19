package com.devglan.controller;

import com.devglan.config.JwtTokenUtil;
import com.devglan.exception.UserNotFoundException;
import com.devglan.model.*;
import com.devglan.payload.Response;
import com.devglan.service.UserService;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		final User user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return new ApiResponse<>(200, "success", new AuthToken(token, user.getUsername()));
	}

	/*
	 * @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public Response resetPassword(HttpServletRequest request,
	 * 
	 * @RequestParam("email") String userEmail) { User user =
	 * userService.findUserByEmail(userEmail); if (user == null) { throw new
	 * UserNotFoundException(userEmail); } String token =
	 * UUID.randomUUID().toString();
	 * userService.createPasswordResetTokenForUser(user, token);
	 * mailSender.send(constructResetTokenEmail(getAppUrl(request),
	 * request.getLocale(), token, user)); return new GenericResponse(
	 * messages.getMessage("message.resetPasswordEmail", null,
	 * request.getLocale())); }
	 * 
	 * public void createPasswordResetTokenForUser(User user, String token) {
	 * PasswordResetToken myToken = new PasswordResetToken(token, user);
	 * passwordTokenRepository.save(myToken); }
	 * 
	 * 
	 */

	@GetMapping("/logout")
	boolean logout(@AuthenticationPrincipal final User user) {
		userService.logout(user);
		return true;
	}

}
