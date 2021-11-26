package cn.chamas.prove;

import cn.chamas.domain.ControllerUser;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserFindAsync extends FindProve{

    @Async("asyncServiceExecutor")
    public CompletableFuture<List<ControllerUser>>byAll() throws IOException {
        return CompletableFuture.completedFuture(super.userByAll());
    }
    @Async("asyncServiceExecutor")
    public CompletableFuture<List<ControllerUser>>byAppoint(ControllerUser controllerUser) throws IOException {
        return CompletableFuture.completedFuture(super.userByAppoint(controllerUser));
    }
    @Async("asyncServiceExecutor")
    public CompletableFuture<ControllerUser>byAppointOne(ControllerUser controllerUser) throws IOException {
        return CompletableFuture.completedFuture(super.userByAppointOne(controllerUser));
    }
}
