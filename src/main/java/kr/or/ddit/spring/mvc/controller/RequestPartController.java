package kr.or.ddit.spring.mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/requestPart")
public class RequestPartController {
	
	/**
	 * Method : view
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일 업로드 화면 요청
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){
		return "mvc/requestPart/view";
	}
	
	/**
	 * Method : upload
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일 업로드 완료 화면 요청
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
//	public String upload(@RequestPart("file") MultipartFile multipartFile, Model model, HttpServletRequest request){
	public String upload(MultipartHttpServletRequest multipartRequest, Model model, HttpServletRequest request){
		//upload 대상 폴더 : /upload
		MultipartFile multipartFile = multipartRequest.getFile("file");
		
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath("/upload");
		String name = multipartFile.getName();
		String originalFilename = multipartFile.getOriginalFilename();
		String filePath = path + File.separator + originalFilename;
		
		
		model.addAttribute("uploadUrl", uploadUrl);
		model.addAttribute("path", path);
		model.addAttribute("name", name);
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("filePath", filePath);
		
		try {
			//파일 전송
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "mvc/requestPart/uploadResult";
	}
	
	/**
	 * Method : pictureDownload
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 서버의 사진파일을 다운로드
	 * @throws IOException 
	 */
	@RequestMapping("/pictureDownload")
	public void pictureDownload(HttpServletResponse response, @RequestParam("pictureName") String pictureName, HttpServletRequest request) throws IOException{
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath(uploadUrl);//절대경로
		File file = new File(path + File.separator + pictureName);
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + pictureName);
		
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		int len = -1;
		while( (len = fis.read(buffer)) != -1){
			sos.write(buffer, 0, len);
		}
		
		fis.close();
		sos.close();
	}
	
	
}
