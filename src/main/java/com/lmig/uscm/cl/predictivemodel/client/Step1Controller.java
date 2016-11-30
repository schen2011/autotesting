package com.lmig.uscm.cl.predictivemodel.client;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lmig.uscm.cl.predictivemodel.client.storage.StorageFileNotFoundException;
import com.lmig.uscm.cl.predictivemodel.client.storage.StorageService;

@Controller
public class Step1Controller {

	@Autowired
    private final StorageService storageService;
	
    @Autowired
	private CoefficientRepository coefficientRepository;
	
    @Autowired
    public Step1Controller(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/step1")
    public String listUploadedFiles(Model model) throws IOException {

//        model.addAttribute("files", storageService
//                .loadAll()
//                .map(path ->
//                        MvcUriComponentsBuilder
//                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
//                                .build().toString())
//                .collect(Collectors.toList()));
    	
    	
    	List<Coefficient> list = coefficientRepository.findAll();
    	model.addAttribute("clist", list);
    	model.addAttribute("message", "Step1: Upload or Select Coefficient");

        return "step1";
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

    @PostMapping("/step1")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
    	storageService.changeFileLoc("json/");
        storageService.store(file);
        
        Coefficient coeff = new Coefficient();
        coeff.setDate(new Date());
        String filename = file.getOriginalFilename();
        String[] name = filename.split("\\.");
        coeff.setName(name[0]);
        coeff.setPath("json/" + file.getOriginalFilename());
        coefficientRepository.save(coeff);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/step1";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    

}
