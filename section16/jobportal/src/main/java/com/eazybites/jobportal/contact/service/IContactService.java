package com.eazybites.jobportal.contact.service;

import com.eazybites.jobportal.dto.ContactRequestDto;
import com.eazybites.jobportal.dto.ContactResponseDto;

import java.util.List;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);

    List<ContactResponseDto> fetchNewContactMsgs();
    List<ContactResponseDto> fetchNewContactMsgsWithSort(String sortBy, String sortDir);
}
