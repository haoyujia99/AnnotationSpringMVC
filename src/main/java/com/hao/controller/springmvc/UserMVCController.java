package com.hao.controller.springmvc;

import com.hao.enums.ResponseCodeMessageMappingEnum;
import com.hao.model.User;
import com.hao.service.IUserService;
import com.hao.util.ResponseJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.hao.controller.springmvc
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 12:04
 */
@RestController
@RequestMapping("/mvc")
public class UserMVCController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/save")
    public ResponseJsonResult save(@RequestBody User user) {

        boolean result = userService.save(user);
        return result ? new ResponseJsonResult(ResponseCodeMessageMappingEnum.SUCCESS) : new ResponseJsonResult
                (ResponseCodeMessageMappingEnum.FAILED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseJsonResult deleteById(@PathVariable(value = "id") int id) {

        boolean result = userService.deleteById(id);
        return result ? new ResponseJsonResult(ResponseCodeMessageMappingEnum.SUCCESS) : new ResponseJsonResult
                (ResponseCodeMessageMappingEnum.FAILED);
    }

    @PutMapping(value = "/update")
    public ResponseJsonResult update(@RequestBody User user) {

        boolean result = userService.update(user);
        return result ? new ResponseJsonResult(ResponseCodeMessageMappingEnum.SUCCESS) : new ResponseJsonResult
                (ResponseCodeMessageMappingEnum.FAILED);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseJsonResult findById(@PathVariable(value = "id") int id) {

        User user = userService.findById(id);
        return new ResponseJsonResult<>(ResponseCodeMessageMappingEnum.SUCCESS, user);
    }

    @GetMapping(value = "/find")
    public ResponseJsonResult findAll() {

        List<User> list = userService.findAll();
        return new ResponseJsonResult<>(ResponseCodeMessageMappingEnum.SUCCESS, list);
    }
}
