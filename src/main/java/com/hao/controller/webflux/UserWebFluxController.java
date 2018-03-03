package com.hao.controller.webflux;

import com.hao.model.User;
import com.hao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * com.hao.controller.webflux
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/13 19:53
 */
@RestController
@RequestMapping("/webflux")
public class UserWebFluxController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/find/{id}")
    public Mono<User> findById(@PathVariable(value = "id") int id) {

        User user = userService.findById(id);
        return Mono.just(user);
    }

    @GetMapping(value = "/find")
    public Flux<User> findAll() {

        List<User> list = userService.findAll();
        return Flux.fromIterable(list);
    }
}
