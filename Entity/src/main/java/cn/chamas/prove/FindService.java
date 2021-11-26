package cn.chamas.prove;

import cn.chamas.domain.ControllerUser;

import java.io.IOException;
import java.util.List;

public abstract class FindService {
    public abstract List<ControllerUser>userByAll() throws IOException;
    public abstract List<ControllerUser>userByAppoint(ControllerUser controllerUser) throws IOException;
    public abstract ControllerUser userByAppointOne(ControllerUser controllerUser) throws IOException;
}
