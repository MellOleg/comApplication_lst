package org.olegmell.controller;

import org.olegmell.domain.Request;
import org.olegmell.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private RequestRepository repository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Request> requests = repository.findAll();

        model.put("requests", requests);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Request message = new Request(text, tag);

        repository.save(message);

        Iterable<Request> requests = repository.findAll();

        model.put("requests", requests);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Request> requests;

        if (filter != null && !filter.isEmpty()) {
            requests = repository.findByTag(filter);
        }else {
            requests = repository.findAll();
        }


        model.put("requests", requests);

        return "main";
    }
}
