package br.com.project.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.api.models.Message;

@Service
public class ServiceApi {
    @Autowired
    private Message message;
}
