package com.hi.jeong.springboot.service.posts;

import com.hi.jeong.springboot.domain.posts.Posts;
import com.hi.jeong.springboot.domain.posts.PostsRepository;
import com.hi.jeong.springboot.web.dto.PostsResponseDto;
import com.hi.jeong.springboot.web.dto.PostsSaveRequestDto;
import com.hi.jeong.springboot.web.dto.PostsUpdateRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestsDto requestsDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        posts.update(requestsDto.getTitle(),requestsDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);
    }
}
