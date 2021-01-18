package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.Data;

@Data
public class PatchDocumentDO {

    private OpEnumDO op;
    private String path;
    private String value;
}
