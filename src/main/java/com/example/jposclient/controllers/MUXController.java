package com.example.jposclient.controllers;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MUXController
{
    @Autowired MUX mux;
    @GetMapping("echo")
    public String echo() throws ISOException
    {
        ISOMsg msg = new ISOMsg();
        msg.setMTI("0800");
        msg.set(11,"00001");
        msg.set(70, "301");
        ISOMsg res = mux.request(msg, 30000);
        return res.toString();
    }
}
