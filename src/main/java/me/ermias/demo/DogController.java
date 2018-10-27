package me.ermias.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DogController {
    @GetMapping("/dog")
    public String loadDogForm(Model model){
        model.addAttribute("dog", new Dog());
        return "dog";
    }

    @PostMapping("/dog")
    public String processDogForm(@Valid Dog dog,
                                 BindingResult result){
        if(result.hasErrors()){
            return "dog";
        }
        return "dogshowconfirm";
    }
}
