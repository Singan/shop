package com.my.shop.service;

import com.my.shop.entity.ItemEntity;
import com.my.shop.repository.PostRepository;
import com.my.shop.request.PostSaveDto;
import com.my.shop.request.PostUpdateDto;
import com.my.shop.response.PostDetailDto;
import com.my.shop.response.PostListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;


    public List<PostListDto> postList() {
        return postRepository.findAll().stream().map(
                item -> new PostListDto(item.getId(), item.getUsername(), item.getTitle(), item.getPrice())).toList();
    }

    @Transactional
    public PostDetailDto postSave(PostSaveDto postSaveDto) {
        ItemEntity item = postRepository.save(
                ItemEntity.builder()
                        .content(postSaveDto.getContent())
                        .price(postSaveDto.getPrice())
                        .title(postSaveDto.getTitle())
                        .username(postSaveDto.getUsername())
                        .build()
        );

        return new PostDetailDto(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice());

    }
    @Transactional
    public PostDetailDto postUpdate(PostUpdateDto postUpdateDto, Long id) {
        ItemEntity item = postRepository.findById(id).orElseThrow(() -> new IllegalStateException("없는 게시글입니다."));

        item.itemUpdate(postUpdateDto);

        return new PostDetailDto(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice());

    }
    @Transactional
    public boolean postDelete(Long id) {
        postRepository.delete(
                postRepository.findById(id).orElseThrow(() -> new IllegalStateException("없는 게시글입니다."))
        );

        return true;
    }
}
