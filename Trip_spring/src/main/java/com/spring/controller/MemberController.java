package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.MemberService;
import com.spring.vo.MemberDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = {"Member API"})
public class MemberController {
    
    @Autowired
    MemberService service;
    
    // 회원 정보 (마이페이지) 
    @ApiOperation(value = "회원정보", notes = "회원한명에 대한 정보")
    @GetMapping("/{id}")
    public ResponseEntity<?> login(@PathVariable String id) {
        try {
            MemberDto member = service.getMember(id);
            if(member != null)
                return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    // 회원 가입
    @ApiOperation(value = "회원가입", notes = "회원의 정보를 받아 처리.")
    @PostMapping("/")
    public ResponseEntity<?> join(@RequestBody MemberDto member){
        try {
            service.regist(member);
            List<MemberDto> list = service.getAllMembers();
            return new ResponseEntity<List<MemberDto>>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }    
    }
    
    // 회원 정보 수정
    @ApiOperation(value = "회원정보수정", notes = "회원정보를 수정합니다.")
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody MemberDto member){
        try {
            service.update(member);
            List<MemberDto> list = service.getAllMembers();
            return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    // 회원 탈퇴
    @ApiOperation(value = "회원정보탈퇴", notes = "회원정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id){
        try {
            service.delete(id);
            List<MemberDto> list = service.getAllMembers();
            return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
        }catch(Exception e) {
            return exceptionHandling(e);
        }
    }
    
    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
