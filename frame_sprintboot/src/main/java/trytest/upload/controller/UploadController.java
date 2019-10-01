package trytest.upload.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping("uploadpage")
	public String upload() {
		return "upload/uploadPage";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req ,
						 @RequestParam(value="file")MultipartFile file, 
						 Model m ) throws IllegalStateException, IOException {
		String filename = System.currentTimeMillis()+file.getOriginalFilename();
		String dststr = req.getServletContext().getRealPath("")+ "jsp/upload/uploaded" + File.separator + filename;
		File dstfile = new File(dststr);
		dstfile.getParentFile().mkdirs();
		file.transferTo(dstfile);
		m.addAttribute("filename" , filename);
		return "upload/showImg";
	}
	
}
