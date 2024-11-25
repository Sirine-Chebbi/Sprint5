package com.sirine.series.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sirine.series.entities.Image;
import com.sirine.series.entities.Serie;
import com.sirine.series.repos.ImageRepository;
import com.sirine.series.repos.SerieRepository;



@Transactional
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;
	
	
	@Autowired
	SerieRepository serieRepository;


	@Autowired
	SerieService serieService;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null); return
		 * imageRepository.save(image);
		 */
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageSerie(MultipartFile file, Long idSerie) throws IOException {
		Serie s = new Serie();
		s.setIdSerie(idSerie);
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).serie(s).build());
	}

	@Override
	public List<Image> getImagesParSerie(Long prodId) {
		Serie s = serieRepository.findById(prodId).get();
		return s.getImages();
	}

}
