package com.example.invest.service.impl;

import com.example.invest.mapper.MemberMapper;
import com.example.invest.model.MemberModel;
import com.example.invest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public MemberModel getMember() {
        return memberMapper.getMember();
    }
}
