package ie.ucd.CurrencyWatcher;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class CurrencyWatcherController {
	
    @GetMapping("/index")

    public @ResponseBody String index() {
	
        return "index.html";
    }
}
