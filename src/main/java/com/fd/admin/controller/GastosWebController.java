package com.fd.admin.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fd.adminHome.data_service.gastos.service.GastosService;
import com.fd.adminHome.data_service.gastos.service.StorageFileNotFoundException;
import com.fd.adminHome.data_service.gastos.service.StorageService;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.FormAddGastoCriteria;
import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * https://spring.io/guides/gs/uploading-files/
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/home/gastos")
public class GastosWebController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GastosWebController.class);
	
	private final StorageService storageService;

    @Autowired
    public GastosWebController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(GastosWebController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @RequestMapping(value = "/addGasto", method = RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute FormAddGastoCriteria criteria,RedirectAttributes redirectAttributes) {
        
    	GastoEntity gEntity = new GastoEntity();
		gEntity.setDescripcion(criteria.getDescripcion());
		gEntity.setMonto(new BigDecimal(criteria.getMonto()));
		gEntity.setPathComprobante(criteria.getFileComprobante().getOriginalFilename());
		gEntity.setTipoGasto(criteria.getTipoGasto());
		try{
			gEntity.setByteComprobante(criteria.getFileComprobante().getBytes());
		}catch(IOException ioe){
			LOGGER.error("Error: ", ioe);
			return ADD_GASTO;
		}
		
		gastosService.saveGastosListDetails(gEntity);
    	
    	storageService.store(criteria.getFileComprobante());
        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + criteria.getFileComprobante().getOriginalFilename() + "!");

        return ADD_GASTO;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<Void> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

	
	public static final String VIEW_FINANCE = "modules/finance/viewFinance";
	private static final String ADD_GASTO = "home/gastos/addGasto";

	@Autowired
	private GastosService gastosService;

	@GetMapping("/viewGastos")
	public String retrieveGastosListDetails() {
		GastosListDetailsSearchCriteria searchCriteria = new GastosListDetailsSearchCriteria();
		GastosListDetailsResult result = gastosService.retrieveGastosListDetails(searchCriteria);
		
		//Start Agrupar gastos por tipo de gasto.
		Map<String,List<GastoEntity>> map = result.getGastosListDetailsEntity().stream().collect(Collectors.groupingBy(GastoEntity::getTipoGasto));
		LOGGER.info(map.toString());
		//End Agrupar gastos por tipo de gasto.
		
		//Start Set
		List<String> listTipoGastos = result.getGastosListDetailsEntity().stream().map(GastoEntity::getTipoGasto).collect(Collectors.toList());
		LOGGER.info(listTipoGastos.toString());
		Set<String> setTipoGasto = listTipoGastos.stream().collect(Collectors.toSet());
		LOGGER.info(setTipoGasto.toString());
		//End Set

		/*
		http://stackoverflow.com/questions/30611870/how-i-can-get-list-from-some-class-properties-with-java-8-stream
		List<String> friendNames = 
			    personList.stream()
			              .flatMap(e->e.getFriends().stream())
			              .collect(Collectors.toList());
		*/
		
		return VIEW_FINANCE;
	}

	/**
	 * This is a form para añadir un gasto.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/addGasto")
	public String addGastosListDetails(Model model) {
		GastoEntity gastosListDetailsEntity = new GastoEntity();
		
		GastosListDetailsSearchCriteria searchCriteria = new GastosListDetailsSearchCriteria();
		gastosService.retrieveGastosListDetails(searchCriteria);
		
		model.addAttribute("gastosListDetailsEntity", gastosListDetailsEntity);
		return ADD_GASTO;
	}

	@PostMapping("/addGasto2")
	public String addGastosListDetails(@RequestBody GastoEntity gastosListDetailsEntity,Model model) {
		gastosService.saveGastosListDetails(gastosListDetailsEntity);
		return ADD_GASTO;
	}

}
