package com.example.myproject.controlers;

import com.example.myproject.models.Post;
import com.example.myproject.repo.ItemReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SignControler {

    @Autowired
    private ItemReposetory itemReposetory;

    @GetMapping ("/Signup")
    public String signUp(Model model) {
        Iterable<Post> posts = itemReposetory.findAll();
        model.addAttribute("posts", posts);
        return "Signup";
    }
    @GetMapping("/Signup/Add")
    public String signUpAdd(Model model) {
        return "SignupAdd";
    }

    @PostMapping("/Signup/Add")
    public String signUpAdd(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String category,
            @RequestParam(required = false) String feedback,
            Model model) {


        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setCategory(category);
        post.setFeedback(feedback);

        itemReposetory.save(post);


        return "redirect:/Signup";
    }



        @PostMapping("/deletePost/{id}")
        public String deletePost(@PathVariable("id") Long id, Model model) {
           Post post = itemReposetory.findById(id).orElseThrow(null);
           itemReposetory.delete(post);

            return "redirect:/Signup";
        }

}
