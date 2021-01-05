package com.example.phonebook.control;

import com.example.phonebook.model.Record;
import com.example.phonebook.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecordController {

    private final RecordService service;

    @Autowired
    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String recordsList(Model model) {
        model.addAttribute("recs", service.findAll());
        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("number") String number) {
        Record rec = null;
        if ("new".equals(number)) {
            rec = new Record();
        } else {
            rec = service.findByNumber(number);
        }
        model.addAttribute("rec", rec);
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("rec") Record record) {
        service.save(record);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("number") String number) {
        service.delete(number);
        return "redirect:/";
    }
}
