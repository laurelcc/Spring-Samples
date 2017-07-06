package web.controller;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by soong on 2017/7/5.
 */
@Controller
public class CustomHandler {

    @RequestMapping("/customerror")
    public ResponseEntity handleStorageFileNotFound() {
        return ResponseEntity.notFound().build();
    }

}
