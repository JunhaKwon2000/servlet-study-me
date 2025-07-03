package com.gn.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import com.gn.dto.Attach;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class AttachService {
	
	// 1. 업로드할 디렉토리 반환
	public static File getUploadDirectory() {
		String dirPath = "D://upload/board";
		
		// 파일을 업로드할 디렉토리 생성
		File uploadDir = new File(dirPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		return uploadDir;
	}
	
	// 2. 정보 중에서 파일 추출
	public static Attach handleUploadFile(HttpServletRequest request, File uploadDir) {
		// form 에서 파일 가져오가 -> name 속성 기준
		
		Attach result = null;
		
		try {
			Part filePart = request.getPart("boardFile");
			
			if (filePart.getSize() > 0) {
				result =  getFileMeta(filePart, uploadDir);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
		return result ;
	}
	
	// 3. 파일 메타 데이터 추출
	public static Attach getFileMeta(Part part, File uploadDir) {
		// 원본 파일 이름 꺼내기
		String oriName = part.getSubmittedFileName();
		
		// oriName 에는 사진.png -> 이걸 qierhlsdjfnl23o491h30[r9dfjqewjrnd.png 이런 느낌으로 바꾸기!
		// 파일 확장자 떼기
		String ext = FilenameUtils.getExtension(oriName);
		
		// 확장자 제외한 파일 이름
		String fileNAme = oriName.substring(0, oriName.indexOf("."));
		
		// UUID 사용 -> 무작위 이름(중복 방지, 그리고 -도 떼주기)
		String saveName = UUID.randomUUID().toString().replace("-", "");
		
		// 중복 방지 파일명 + 확장자
		File file = new File(uploadDir, saveName + "." + ext);
		
		// 파일 서버에 저장
		try (InputStream input = part.getInputStream(); OutputStream output = Files.newOutputStream(file.toPath())) {
			// output 경로에 input에 담긴 데이터 보내기
			input.transferTo(output);
		} catch (Exception e) {
			
		}
		
		Attach a = new Attach();
		a.setOriName(oriName);
		a.setReName(saveName + "." + ext);
		
		return a;
	}

}
