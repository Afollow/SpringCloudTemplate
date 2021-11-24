package cn.chamas.prove;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class WxUserFindAsync extends FindProve{

//    @Async("asyncServiceExecutor")
//    public CompletableFuture<List<$>> $() throws IOException {
//        return CompletableFuture.completedFuture(super.$());
//    }
//    @Async("asyncServiceExecutor")
//    public CompletableFuture<$> $($ $) throws IOException {
//        return CompletableFuture.completedFuture(super.$($));
//    }
}
