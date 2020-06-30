package com.lxisoft.mockexam;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.lxisoft.mockexam");

        noClasses()
            .that()
                .resideInAnyPackage("com.lxisoft.mockexam.service..")
            .or()
                .resideInAnyPackage("com.lxisoft.mockexam.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.lxisoft.mockexam.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
