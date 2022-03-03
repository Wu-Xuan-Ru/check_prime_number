package prime.check.check_prime_number;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Control {
    @PostMapping("/oneprime")
    public String oneprime(@RequestParam("num") int num, Model model){
        List list = new ArrayList();
        list.addAll(List.of(561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973, 75361));


        BigInteger temp = null;
        boolean bool = true;
        for (int i = num - 1; i >= 1; i--) {
            temp = null;
            temp = BigInteger.valueOf((long)i);
            temp = temp.pow(num);
            temp = temp.subtract(BigInteger.valueOf(i));
            if(!temp.mod(BigInteger.valueOf(num)).equals(BigInteger.ZERO)){
                bool = false;
                break;
            }
        }

//        if(num == 1){
//            model.addAttribute("isprime", num + "is not a prime number!");
//            return "oneresult";
//        }
//        for (int i = num - 1; i >= 2; i--) {
//            if(num % i == 0){
//                model.addAttribute("isprime", num + " is not a prime number!");
//                return "oneresult";
//            }
//        }
//        model.addAttribute("isprime", num + " is a prime number!");
        model.addAttribute("isprime", bool);
        return "oneresult";
    }
    @GetMapping
    public String index(){
        return "index";
    }
    @PostMapping("allprime")
    public String allprime(@RequestParam("num") int num, Model model){
        Map<Integer, String> map = new HashMap<Integer, String>();
        List list = new ArrayList();
        list.addAll(List.of(561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973, 75361));
        map.put(1, "false");

//        for (int i = 1; i <= num; i++) {
//            map.put(i, "null");
//        }
//        map.put(1, "false");
//        for (int i = 2; i <= num; i++) {
//            for (int j = 2; j <= num - 1; j++) {
//                if(i % j == 0 && i != j){
//                    map.put(i, "false");
//                    break;
//                }
//            }
//        }
//        for (int i = 1; i <= num; i++) {
//            if(map.get(i).equals("null")){
//                map.put(i, "true");
//            }
//        }
//        BigInteger temp = null;
//        boolean bool = true;
//        for (int i = num - 1; i >= 1; i--) {
//            temp = null;
//            temp = BigInteger.valueOf((long)i);
//            temp = temp.pow(num);
//            temp = temp.subtract(BigInteger.valueOf(i));
//            if(!temp.mod(BigInteger.valueOf(num)).equals(BigInteger.ZERO)){
//                bool = false;
//            }
//        }
        for (int i = 2; i <= num; i++) {
        BigInteger temp = null;
        boolean bool = true;
        for (int j = num - 1; j >= 1; j--) {
            bool = true;
            temp = null;
            temp = BigInteger.valueOf((long)j);
            temp = temp.pow(i);
            temp = temp.subtract(BigInteger.valueOf(j));
            if(!temp.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)){
                map.put(i, "false");
                bool = false;
                break;
            }
            if(j == 2 && bool){
                map.put(i, "true");
            }
        }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j <= num; j++) {
                if(list.get(i).equals(j)){
                    map.put(j, "false");
                }
            }
        }

        model.addAttribute("list", map);
        return "allresult";
    }
}
