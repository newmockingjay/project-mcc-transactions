package ru.zayceva.MccTransactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.zayceva.MccTransactions.dto.TransactionsDTO;
import ru.zayceva.MccTransactions.service.FileService;
import ru.zayceva.MccTransactions.service.MccService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class FilesController {
    private final FileService fileService;
    private final MccService mccService;
    @Autowired
    public FilesController(FileService fileService, MccService mccService) {
        this.fileService = fileService;
        this.mccService = mccService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.save(file.getInputStream());
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload file: " + e.getMessage());
        }
    }

    @GetMapping("/mcc")
    public ResponseEntity<String> mcc() {
        try {
            mccService.save();
            return ResponseEntity.ok("OK");
        } catch (FileNotFoundException e) {
            return ResponseEntity.badRequest().body("Fail");
        }
    }

}
