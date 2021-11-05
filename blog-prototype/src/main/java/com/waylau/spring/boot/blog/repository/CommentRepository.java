package com.waylau.spring.boot.blog.repository;

import com.waylau.spring.boot.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment 仓库.
 *
 * @since 1.0.0 2017年4月7日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
