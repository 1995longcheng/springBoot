package com.llc.exception;

/**
 * Created by catt on 2019/11/28.
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在");
    }
}
