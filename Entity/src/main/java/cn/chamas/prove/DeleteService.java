package cn.chamas.prove;

import cn.chamas.domain.ControllerUser;
import java.io.IOException;

public abstract class DeleteService {
    public abstract void user(ControllerUser controllerUser) throws IOException;
}
