package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.UploadedImageFile;
import util.GenStrUtil;

@Controller
public class UploadController {
	@RequestMapping("/uploadImage")
	public ModelAndView uploadImage(HttpServletRequest req , HttpServletResponse res,UploadedImageFile file) throws IllegalStateException, IOException {
		String name = GenStrUtil.get(10);
		String newFileName=name +".jpg";
		File newFile = new File(req.getServletContext().getRealPath("/img") , newFileName);
		newFile.getParentFile().mkdirs();
		file.getImage().transferTo(newFile);
		
		
		ModelAndView mav = new ModelAndView("showUploadedFile");
		mav.addObject("imageName",newFileName);
		return mav ;
	}
	
	
}
