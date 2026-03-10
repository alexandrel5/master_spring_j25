package com.eazybites.jobportal.contact.service.impl;

import com.eazybites.jobportal.constants.ApplicationConstants;
import com.eazybites.jobportal.contact.service.IContactService;
import com.eazybites.jobportal.dto.ContactRequestDto;
import com.eazybites.jobportal.dto.ContactResponseDto;
import com.eazybites.jobportal.entity.Contact;
import com.eazybites.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {

        boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        if(contact != null && contact.getId() != null){
            result = true;
        }
        return result;
    }

    @Override
    public List<ContactResponseDto> fetchNewContactMsgs() {
        List<Contact> contacts = contactRepository.findContactsByStatus(ApplicationConstants.NEW_MESSAGE);
        List<ContactResponseDto> responseDtos = contacts.stream()
                .map(this::transformToDto)
                .collect(Collectors.toList());
        return responseDtos;

    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto,contact);
        contact.setStatus(ApplicationConstants.NEW_MESSAGE);
        return contact;
    }

    private ContactResponseDto transformToDto(Contact contact){
        ContactResponseDto contactResponseDto = new ContactResponseDto(contact.getId(),
                contact.getName(), contact.getEmail(), contact.getUserType(), contact.getSubject(),
                contact.getMessage(), contact.getStatus(), contact.getCreatedAt());
        return contactResponseDto;
    }
}
