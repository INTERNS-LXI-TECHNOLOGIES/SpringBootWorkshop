package com.lxisoft.mockexam.service;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(long id)
    {
        super("Record Not Found Exception with id =" +id);
    }
}
