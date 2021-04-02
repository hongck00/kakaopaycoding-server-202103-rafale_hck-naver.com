package com.example.invest.controller;

import com.example.invest.model.MemberModel;
import com.example.invest.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final Environment env;
    private final MemberService memberService;

    @GetMapping("/members")
    @ResponseBody
    public MemberModel getMember() {
        return memberService.getMember();
    }
}
