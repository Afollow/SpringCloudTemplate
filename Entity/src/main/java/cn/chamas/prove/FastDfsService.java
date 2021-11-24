package cn.chamas.prove;

import org.springframework.web.multipart.MultipartFile;

public abstract class FastDfsService {
    public abstract String upload(MultipartFile file);
    public abstract Boolean delete(String path);
}
