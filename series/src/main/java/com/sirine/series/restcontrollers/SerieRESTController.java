package com.sirine.series.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sirine.series.entities.Serie;
import com.sirine.series.service.SerieService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class SerieRESTController {
	
	@Autowired
	SerieService serieService;
	
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Serie> getAllSeries() {
		return serieService.getAllSeries();
	}
	
	@RequestMapping(value="/getbyid/{idSerie}",method = RequestMethod.GET)
	public Serie getSerieById(@PathVariable("idSerie") Long id) {
		return serieService.getSerie(id);
	 }
	
	@RequestMapping(value="/addserie",method = RequestMethod.POST)
	public Serie createSerie(@RequestBody Serie serie) {
		return serieService.saveSerie(serie);
	}
	
	@RequestMapping(value="/updateSerie",method = RequestMethod.PUT)
	public Serie updateSerie(@RequestBody Serie serie) {
		return serieService.updateSerie(serie);
	}

	@RequestMapping(value="/delserie/{id}",method = RequestMethod.DELETE)
	public void deleteSerie(@PathVariable("id") Long id)
	{
		serieService.deleteSerieById(id);
	}
	
	@RequestMapping(value="/serieGenre/{idG}",method = RequestMethod.GET)
	public List<Serie> getSeriesByGenreId(@PathVariable("idG") Long idG) {
	return serieService.findByGenreIdG(idG);
	}
}