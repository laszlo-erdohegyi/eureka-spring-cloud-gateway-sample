package hu.cepl.casemanager.service.impl.inmemory;

import hu.cepl.casemanager.exception.CaseServiceException;
import hu.cepl.casemanager.model.Case;
import hu.cepl.casemanager.service.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class CaseServiceInmemoryImpl implements CaseService {

    private final Case case1 = Case.builder().id(1L).caseNumber("2025/1").description("Description of case 1")
            .closureDate(LocalDateTime.of(2025, 2, 3, 14, 15)).build();
    private final Case case2 = Case.builder().id(2L).caseNumber("2025/2").description("Description of case 2").build();
    private final Case case3 = Case.builder().id(3L).caseNumber("2025/3").description("Description of case 3").build();
    private final Case case4 = Case.builder().id(4L).caseNumber("2025/4").description("Description of case 4").build();
    private final Case case5 = Case.builder().id(5L).caseNumber("2025/5").description("Description of case 5").build();
    private final List<Case> cases = List.of(case1, case2, case3, case4, case5);

    @Override
    public List<Case> findAll() {
        return cases;
    }

    @Override
    public Case findById(Long id) {
        if (id == null)
            throw new CaseServiceException("The given id must not be null", HttpStatus.BAD_REQUEST);

        return cases.stream()
                .filter(item -> Objects.equals(id, item.getId()))
                .findFirst()
                .orElseThrow(() -> new CaseServiceException("No case found with the given id", HttpStatus.NOT_FOUND));
    }

}
