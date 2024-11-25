package com.sirine.series.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.sirine.series.entities.Image;


public interface ImageService {

	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;
	
	Image uplaodImageSerie(MultipartFile file,Long idSerie) throws IOException;
	List<Image> getImagesParSerie(Long serieId);
	
}
