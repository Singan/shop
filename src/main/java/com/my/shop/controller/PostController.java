package com.my.shop.controller;

import com.my.shop.request.PostSaveDto;
import com.my.shop.request.PostUpdateDto;
import com.my.shop.response.PostDetailDto;
import com.my.shop.response.PostListDto;
import com.my.shop.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostListDto>> postList(){
        return ResponseEntity.ok(postService.postList());
    }

    @PostMapping
    public ResponseEntity<PostDetailDto> postSave(@RequestBody PostSaveDto postSaveDto){
        return ResponseEntity.ok(postService.postSave(postSaveDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> postDelete(@PathVariable("id") Long id){
        postService.postDelete(id);
        return ResponseEntity.ok("삭제완료");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDetailDto> postUpdate(@PathVariable("id") Long id,@RequestBody PostUpdateDto postUpdateDto){
        return ResponseEntity.ok(postService.postUpdate(postUpdateDto,id));
    }
}
