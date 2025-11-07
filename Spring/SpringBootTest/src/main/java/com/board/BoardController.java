package com.board;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

// 웹 상에서 들어오는 클라이언트 요청을 받아 처리(dao에게 넘김 => 결과가 오면 => jsp로 넘김)
@Controller
public class BoardController {
    @Autowired
    BoardDAO dao;

    //http://localhost/hello
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("city", "seattle");
        model.addAttribute("code", "12345");

        return "hello"; //view name
        // model이 hello view까지 전달되어서 포워딩 해줌.
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Board> list = dao.selectAll(); // 모든 글 정보
        model.addAttribute("list", list);

        return "list";
    }
    @GetMapping("/read")
    public String read(Model model, @RequestParam("num") String num) throws Exception {
        Board b = dao.selectOne(num);
        model.addAttribute("b", b);

        return "read";
    }
    @GetMapping("/insertForm")
    public String insertForm() throws Exception {
        return "insertForm";
    }
    @PostMapping("/insertProcess")
    public String insertProcess(@ModelAttribute Board b) throws Exception {
        dao.insert(b);
        return "redirect:/list"; // 그냥 리스트로 하면 list 비어있는 페이지 나옴
    }
}
