package hu.cepl.casemanager.service;

import hu.cepl.casemanager.model.Case;

import java.util.List;

public interface CaseService {

    List<Case> findAll();

    Case findById(Long id);

}
