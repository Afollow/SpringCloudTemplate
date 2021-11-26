package cn.chamas.controller.prove;

import cn.chamas.prove.FastDfsProve;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.concurrent.CompletableFuture;

@Service
public class FastDfsAsync extends FastDfsProve {

    @Async("asyncServiceExecutor")
    public CompletableFuture<String> uploadFile(MultipartFile file){
        return CompletableFuture.completedFuture(super.upload(file));
    }
    @Async("asyncServiceExecutor")
    public CompletableFuture<Boolean> deleteFile(String path){
        return CompletableFuture.completedFuture(super.delete(path));
    }

    @Override
    public String getPath(String path) {
        return super.getPath(path);
    }
}
