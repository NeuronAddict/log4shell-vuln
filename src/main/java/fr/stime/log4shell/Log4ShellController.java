package fr.stime.log4shell;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Log4ShellController {

    private static final Logger logger = LogManager.getLogger(Log4ShellController.class);

    @GetMapping("/")
    public String index(@RequestParam String data) {
        logger.info(data);
        return "We log " + data;
    }

    @GetMapping("/lookup")
    public Object lookup(@RequestParam String name) throws Exception{
        //@Example(uri = {"/lookup?name=java:comp/env"})
        return new javax.naming.InitialContext().lookup(name);
    }

}
