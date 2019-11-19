/*
 * package com.devglan.controller;
 * 
 * import java.io.FileNotFoundException; import java.io.IOException;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
 * import org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.devglan.service.impl.FileStorageService;
 * 
 * @RestController public class FileDownloadController {
 * 
 * 
 * @Autowired private FileStorageService fileStorageService;
 * 
 * @GetMapping("/downloadFile/{fileName:.+}") public ResponseEntity<Resource>
 * downloadFile(@PathVariable String fileName, HttpServletRequest request)
 * throws FileNotFoundException { // Load file as Resource Resource resource =
 * (Resource) fileStorageService.loadFileAsResource(fileName);
 * 
 * // Try to determine file's content type String contentType = null; try {
 * contentType =
 * request.getServletContext().getMimeType(((org.springframework.core.io.
 * Resource) resource).getFile().getAbsolutePath()); } catch (IOException ex) {
 * System.out.println("Could not determine file type."); }
 * 
 * // Fallback to the default content type if type could not be determined
 * if(contentType == null) { contentType = "application/octet-stream"; }
 * 
 * return ResponseEntity.ok()
 * .contentType(MediaType.parseMediaType(contentType))
 * .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
 * ((org.springframework.core.io.Resource) resource).getFilename() + "\"")
 * .body(resource); }
 * 
 * }
 */