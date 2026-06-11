package com.negoreserva.common.feature.general.storage.service;

import com.negoreserva.common.feature.general.storage.contract.IUploadFileService;
import com.negoreserva.common.feature.general.storage.feature.cloudinary.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StorageService implements IUploadFileService {

    private final CloudinaryService cloudinaryService;

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        return cloudinaryService.uploadFile(file, folderName);
    }

    @Override
    public String uploadFile(MultipartFile file) {
        return cloudinaryService.uploadFile(file);
    }
}
