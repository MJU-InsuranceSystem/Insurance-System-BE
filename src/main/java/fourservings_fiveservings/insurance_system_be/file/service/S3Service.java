package fourservings_fiveservings.insurance_system_be.file.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import fourservings_fiveservings.insurance_system_be.common.exception.FileException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    public String uploadFile(MultipartFile multipartFile, String fileType) {

        if (multipartFile == null || multipartFile.isEmpty()) {

            return null;
        }

        String fileName = createFileName(multipartFile.getOriginalFilename());
        String path = fileType + fileName;
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucketName, path, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new FileException(ErrorType.UPLOAD_FILE_FAILED);
        }

        return fileName;
    }

    public String getFileUrl(String fileType, String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return null;
        }
        String filePath = fileType + fileName;
        return amazonS3.getUrl(bucketName, filePath).toString();
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    //  "."의 존재 유무만 판단
    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileException(ErrorType.NOT_SUPPORTED_FILE_FORMAT);
        }
    }
}
