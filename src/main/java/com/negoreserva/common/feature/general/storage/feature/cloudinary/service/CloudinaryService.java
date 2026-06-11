package com.negoreserva.common.feature.general.storage.feature.cloudinary.service;

import com.cloudinary.Cloudinary;
import com.negoreserva.common.feature.general.storage.contract.IUploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CloudinaryService implements IUploadFileService {
    private final Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            Map<Object, Object> options = buildUploadOptions(file);
            options.put("folder", folderName);

            var uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            return buildSecureUrl(uploadedFile, file);
        } catch (IOException e) {
            log.error("Erro ao fazer upload do arquivo '{}': {}", file.getOriginalFilename(), e.getMessage());
            return null;
        }
    }

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            Map<Object, Object> options = buildUploadOptions(file);
            var uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            return buildSecureUrl(uploadedFile, file);
        } catch (IOException e) {
            log.error("Erro ao fazer upload do arquivo '{}': {}", file.getOriginalFilename(), e.getMessage());
            return null;
        }
    }

    private Map<Object, Object> buildUploadOptions(MultipartFile file) {
        Map<Object, Object> options = new HashMap<>();
        if (isVideo(file)) {
            options.put("resource_type", "video");
            options.put("eager_async", true);
            log.info("Upload de vídeo detectado: {}", file.getOriginalFilename());
        } else {
            options.put("resource_type", "image");
        }
        return options;
    }

    private String buildSecureUrl(Map<?, ?>  uploadedFile, MultipartFile file) {
        String publicId = (String) uploadedFile.get("public_id");
        if (isVideo(file)) return (String) uploadedFile.get("secure_url");
        return cloudinary.url().secure(true).generate(publicId);
    }

    private boolean isVideo(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("video/");
    }
}