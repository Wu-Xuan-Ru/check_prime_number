package prime.check.check_prime_number;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Control {
    @PostMapping("/oneprime")
    public String oneprime(@RequestParam("num") int num, Model model){
        if(num == 1){
            model.addAttribute("isprime", num + "is not a prime number!");
            return "oneresult";
        }
        for (int i = num - 1; i >= 2; i--) {
            if(num % i == 0){
                model.addAttribute("isprime", num + " is not a prime number!");
                return "oneresult";
            }
        }
        model.addAttribute("isprime", num + " is a prime number!");
        return "oneresult";
    }
    @GetMapping
    public String index(){
        return "index";
    }
    @PostMapping("allprime")
    public String allprime(@RequestParam("num") int num, Model model){
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 1; i <= num; i++) {
            map.put(i, "null");
        }
        map.put(1, "false");
        for (int i = 2; i <= num; i++) {
            for (int j = 2; j <= num - 1; j++) {
                if(i % j == 0 && i != j){
                    map.put(i, "false");
                    break;
                }
            }
        }
        for (int i = 1; i <= num; i++) {
            if(map.get(i).equals("null")){
                map.put(i, "true");
            }
        }
        model.addAttribute("list", map);
        return "allresult";
    }
}
