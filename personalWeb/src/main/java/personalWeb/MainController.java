package personalWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping(value={"/main.do"}, method={RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "main/home";
    }
}
