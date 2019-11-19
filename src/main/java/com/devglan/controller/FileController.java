/*
 * package com.devglan.controller;
 * 
 * import org.apache.log4j.Logger; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 * 
 * import com.devglan.model.DBFile; import com.devglan.payload.Response;
 * 
 * @RestController public class FileController<UploadFileResponse> {
 * 
 * private static final Logger logger = Logger.getLogger(FileController.class);
 * 
 * @Autowired private com.devglan.service.impl.DBFileStorageService
 * DBFileStorageService;
 * 
 * @PostMapping("/uploadFile") public Response uploadFile(@RequestParam("file")
 * MultipartFile file) { DBFile dbFile = DBFileStorageService.storeFile(file);
 * 
 * String fileDownloadUri =
 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
 * .path(dbFile.getId()).toUriString();
 * 
 * return new Response(dbFile.getFileName(), fileDownloadUri,
 * file.getContentType(), file.getSize()); }
 * 
 * 
 * @PostMapping("/uploadMultipleFiles") public List<UploadFileResponse>
 * uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) { return
 * Arrays.asList(files).stream().map(file ->
 * uploadFile(file)).collect(Collectors.toList()); }
 * 
 * 
 * @GetMapping("/downloadFile/{fileId}") public ResponseEntity<Resource>
 * downloadFile(@PathVariable String fileId) { // Load file from database DBFile
 * dbFile = DBFileStorageService.getFile(fileId);
 * 
 * return ResponseEntity.ok()
 * .contentType(MediaType.parseMediaType(dbFile.getFileType()))
 * .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
 * dbFile.getFileName() + "\"") .body(new ByteArrayResource(dbFile.getData()));
 * }
 * 
 * 
 * }
 */