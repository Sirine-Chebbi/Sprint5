package com.sirine.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sirine.series.entities.Image;


public interface ImageRepository extends JpaRepository<Image , Long> {

}
