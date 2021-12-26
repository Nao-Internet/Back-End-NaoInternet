package com.naoInternet.Service;

import com.naoInternet.Entity.Comment;

import java.util.Date;
import java.util.List;

public interface ICommentService extends CrudService<Comment> {
    public List<Comment> find(Date publication_Date) throws Exception;

}
