package cn.chamas.dao;

import cn.chamas.domain.ControllerUser;

import java.util.List;

public interface FindDao {
    List<ControllerUser> userByAll();
    List<ControllerUser>userByAppoint(ControllerUser controllerUser);
    ControllerUser userByAppointOne(ControllerUser controllerUser);
}
