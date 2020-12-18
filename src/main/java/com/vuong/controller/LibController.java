package com.vuong.controller;

import com.vuong.entity.Book;
import com.vuong.service.LibServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LibController {
    @Autowired
    private LibServiceIF libService;

    @RequestMapping(path = "/listBook")
    public String toListBook(Model model) {
        model.addAttribute("books", libService.getAllBook());
        return "listBook";
    }

    @RequestMapping(path = "/initData")
    public String initDate() {
        libService.initDate();
        return "redirect:/listBook";
    }

    @RequestMapping(path = "/addBook")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("cateList", getCateList());
        return "bookForm";
    }
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book){
        libService.saveBook(book);
        return "redirect:/listBook";
    }

    @RequestMapping(path = "/edit/{id}")
    public String editBook(@PathVariable int id, Model model){
        model.addAttribute("book", libService.getBookById(id));
        model.addAttribute("cateList", getCateList());
        return "bookForm";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable int id){
        libService.deleteBookById(id);
        return "redirect:/listBook";
    }

    public Map<Integer, String> getCateList() {
        Map<Integer, String> cateList = new HashMap<>();
        libService.getAllCategory().forEach(cate -> cateList.put(cate.getCateId(), cate.getCateName()));
        return cateList;
    }


}
