package com.som.blog.service;

import com.som.blog.config.ServiceName;
import com.som.blog.domain.Comment;
import com.som.blog.domain.User;
import com.som.blog.domain.base.UserRole;

/**
 * @author som
 */
public class CommentServiceTest extends AbstractGenericServiceTest<Comment> {
    @Override
    protected IGenericService<Comment> getService() {
        return (ICommentService) appContext.getBean(ServiceName.commentService.name());
    }

    @Override
    protected Comment getFirstEntity() {
        User user = new User("login1", "passwd1", "email1@example.com", UserRole.USER);
        user.setId(1L);

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setBody("Body1");
        comment.setParentId(11L);

        return comment;
    }

    @Override
    protected Comment getSecondEntity() {
        User user = new User("login1", "passwd1", "email1@example.com", UserRole.USER);
        user.setId(2L);

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setBody("Body2");
        comment.setParentId(12L);

        return comment;
    }
}
