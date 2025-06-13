package com.fd.mvc.controller;

import com.fd.mvc.model.UploadForm;
import com.fd.mvc.service.FileStorageService;
import com.fd.mvc.service.FileUploadResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class UploadWebController {

    private final FileStorageService fileStorageService;

    public UploadWebController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("uploadForm", new UploadForm());
        return "pages/utils/upload";
    }

    @PostMapping("/upload")
    public String multiFileUpload(@ModelAttribute UploadForm form,
                                  RedirectAttributes redirectAttributes) {

        List<FileUploadResult> storedFiles = fileStorageService.storeFiles(form.getFiles());
        String uploadedFileName = storedFiles.stream()
                .map(FileUploadResult::fileName)
                .collect(Collectors.joining(", "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
        } else {
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + uploadedFileName + "'");
            redirectAttributes.addFlashAttribute("files", storedFiles);
        }

        return "redirect:/uploadStatus";

    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "pages/utils/uploadStatus";
    }

}
