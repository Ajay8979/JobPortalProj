package com.devglan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devglan.property.FileStorageProperties;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties({ FileStorageProperties.class })
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces =  MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		File convertFile = new File(
				"C:\\Users\\sajay\\Downloads\\SpringRegistrationAndLoginWithTokenGen-master (1)\\SpringRegistrationAndLoginWithTokenGen-master\\uploads"
						+ multipartFile.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(multipartFile.getBytes());
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value="/uploadImage2",method = RequestMethod.POST)
	 * public @ResponseBody String uploadImage2(@RequestParam("imageValue") String
	 * imageValue,HttpServletRequest request) { try { //This will decode the String
	 * which is encoded by using Base64 class byte[]
	 * imageByte=Base64.decodeBase64(imageValue);
	 * 
	 * String directory=servletContext.getRealPath("/")+"images/sample.jpg";
	 * 
	 * new FileOutputStream(directory).write(imageByte); return "success "; }
	 * catch(Exception e) { return "error = "+e; }
	 * 
	 * }
	 */

}
