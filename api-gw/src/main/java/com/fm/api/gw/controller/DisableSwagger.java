package com.fm.api.gw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/16 15:30
 */
@RestController
@Slf4j
//@Profile("!dev")
public class DisableSwagger {

//    @RequestMapping(value = "swagger-ui.html",method = RequestMethod.GET)
//    public void disableSwagger(HttpServletResponse response) throws IOException {
//        response.setStatus(HttpStatus.NOT_FOUND.value());
//    }
}
