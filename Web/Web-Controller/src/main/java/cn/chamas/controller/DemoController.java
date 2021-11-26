package cn.chamas.controller;

import cn.chamas.domain.ControllerUser;
import cn.chamas.prove.InsertService;
import cn.chamas.prove.UpdateService;
import cn.chamas.prove.UserFindAsync;
import cn.chamas.util.ResultBody;
import cn.chamas.util.Tool;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin
@RestController
public class DemoController {
    @Autowired
    private ControllerUser localControllerUser;
    @Autowired
    private ResultBody resultBody;
    @Autowired
    private UserFindAsync findAsync;
    @Autowired
    private InsertService insertService;
    @Autowired
    private UpdateService updateService;

    @SneakyThrows
    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public String demo() {
        return "Hello world";
    }

    @SneakyThrows
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public ResultBody insert(ControllerUser user) {
        resultBody.ready();
        if(Tool.isEmpty(user) || Tool.isEmpty(user.getUsername())){
            resultBody.setCode(100);
            resultBody.setMsg("注册用户数据有误");
        }else{
            localControllerUser.setUsername(user.getUsername());
            localControllerUser.setGender(Tool.isEmpty(user.getGender()) ? 0 : user.getGender());
            localControllerUser.setDescribe(Tool.isEmpty(user.getDescribe()) ? "一个平凡的人" : user.getDescribe());
            localControllerUser.setBirthday(Tool.isEmpty(user.getBirthday()) ? new Date("1970/12/31") : user.getBirthday());
            insertService.user(localControllerUser);
            resultBody.setMsg("新增数据成功");
        }
        return resultBody;
    }

    @SneakyThrows
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query() {
        resultBody.ready();
        long start = System.currentTimeMillis();
        CompletableFuture<List<ControllerUser>> future = findAsync.byAll();
        CompletableFuture.allOf(future).join();
        resultBody.setData(future.get());
        resultBody.setMsg("数据查询完毕，耗时："+ (System.currentTimeMillis() - start) + "毫秒");
        return resultBody;
    }

    @SneakyThrows
    @RequestMapping(value = "query/all", method = RequestMethod.GET)
    public ResultBody queryAll(ControllerUser user1, ControllerUser user2) {
        resultBody.ready();
        if(Tool.isEmpty(user1) || (Tool.isEmpty(user1.getUsername()) && Tool.isEmpty(user1.getGender().toString())) ||
                Tool.isEmpty(user2) || (Tool.isEmpty(user2.getUsername()) && Tool.isEmpty(user2.getGender().toString()))) {
            resultBody.setCode(100);
            resultBody.setMsg("查询用户数据有误");
        }else{
            long start = System.currentTimeMillis();
            CompletableFuture<List<ControllerUser>> future1 = findAsync.byAppoint(user1);
            CompletableFuture<List<ControllerUser>> future2 = findAsync.byAppoint(user2);
            CompletableFuture.allOf(future1, future2).join();
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(future1.get());
            String str = "---------------------------分割线--------------------------------";
            objects.add(str);
            objects.add(future2.get());
            resultBody.setData(objects);
            resultBody.setMsg("数据查询完毕，耗时："+ (System.currentTimeMillis() - start) + "毫秒");
        }
        return resultBody;
    }

    @SneakyThrows
    @RequestMapping(value = "query/one", method = RequestMethod.GET)
    public ResultBody queryOne(ControllerUser user1, ControllerUser user2) {
        resultBody.ready();
        if(user1 == null || (Tool.isEmpty(user1.getUsername()) && Tool.isEmpty(user1.getGender().toString())) ||
                user2 == null || (Tool.isEmpty(user2.getUsername()) && Tool.isEmpty(user2.getGender().toString()))) {
            resultBody.setCode(100);
            resultBody.setMsg("查询用户数据有误");
        }else{
            long start = System.currentTimeMillis();
            CompletableFuture<ControllerUser> future1 = findAsync.byAppointOne(user1);
            CompletableFuture<ControllerUser> future2 = findAsync.byAppointOne(user2);
            CompletableFuture.allOf(future1, future2).join();
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(future1.get());
            String str = "---------------------------分割线--------------------------------";
            objects.add(str);
            objects.add(future2.get());
            resultBody.setData(objects);
            resultBody.setMsg("数据查询完毕，耗时："+ (System.currentTimeMillis() - start) + "毫秒");
        }
        return resultBody;
    }

    @SneakyThrows
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ResultBody update(ControllerUser user) {
        resultBody.ready();
        if(Tool.isEmpty(user) || Tool.isEmpty(user.getUsername()) || (Tool.isEmpty(user.getGender().toString()) &&
                Tool.isEmpty(user.getDescribe()) && Tool.isEmpty(user.getBirthday().toString()))) {
            resultBody.setCode(100);
            resultBody.setMsg("查询用户数据有误");
        }else{
            localControllerUser.ready();
            localControllerUser.setUsername(user.getUsername());
            CompletableFuture<ControllerUser> future = findAsync.byAppointOne(localControllerUser);
            CompletableFuture.allOf(future).join();
            ControllerUser newControllerUser = future.get();
            if(newControllerUser == null){
                resultBody.setCode(101);
                resultBody.setMsg("用户不存在");
            }else{
                localControllerUser.setUid(newControllerUser.getUid());
                localControllerUser.setGender(Tool.isEmpty(user.getGender()) ? null : user.getGender());
                localControllerUser.setDescribe(user.getDescribe());
                localControllerUser.setBirthday(user.getBirthday());
                updateService.user(localControllerUser);
                resultBody.setMsg("用户数据更新完成");
            }
        }
        return resultBody;
    }
}
