package com.negoreserva.common.feature.general.storage.contract;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
    String uploadFile(MultipartFile file, String folderName);
    String uploadFile(MultipartFile file);
}
