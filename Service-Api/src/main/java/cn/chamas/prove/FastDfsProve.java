package cn.chamas.prove;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsServerException;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class FastDfsProve extends FastDfsService{

    @Value("${fastDfsPath}")
    private String fastDfsPath;
    @Value("${fastDfsSpec}")
    private String fastDfsSpec;
    @Autowired
    private FastFileStorageClient fileStorageClient;

    @Override
    public String upload(MultipartFile file){
        String result = null;
        String fileName = file.getOriginalFilename();
        String fileExName = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            StorePath storePath = fileStorageClient.uploadImageAndCrtThumbImage(
                    file.getInputStream(), file.getSize(), fileExName, null);
            result = fastDfsPath + storePath.getFullPath();
        } catch (IOException e) {
            result = null;
        }
        return result;
    }
    @Override
    public Boolean delete(String path) {
        Boolean result;
        try {
            fileStorageClient.deleteFile( path);
            result = true;
        } catch (FdfsUnsupportStorePathException e) {
            result = false;
        }catch (FdfsServerException e){
            result = false;
        }
        return result;
    }
    public String getMinPath(String path){
        String result;
        int index = path.lastIndexOf(".");
        String subPath = path.substring(0, index);
        String fileExName = path.substring(path.lastIndexOf(".") + 1);
        result = subPath + "_" + fastDfsSpec + "." + fileExName;
        return result;
    }
}
