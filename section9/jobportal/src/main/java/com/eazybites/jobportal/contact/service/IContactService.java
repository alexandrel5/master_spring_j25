package com.eazybites.jobportal.contact.service;

import com.eazybites.jobportal.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
