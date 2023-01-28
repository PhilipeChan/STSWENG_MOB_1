package com.orangeandbronze.enlistment;

import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

class Student {

    private final int studentNumber;
    private final Collection<Section> sections = new HashSet<>();

    Student(int studentNumber, Collection<Section> sections) {
        if (studentNumber < 0)
            throw new IllegalArgumentException("studentNumber should be non-negative, was: " + studentNumber);
        notNull(sections);
        this.studentNumber = studentNumber;
        this.sections.addAll(sections);
        this.sections.removeIf(Objects::isNull);
    }

    Student(int studentNumber) {
        this(studentNumber, Collections.emptyList());
    }

    void enlist(Section newSection) {
        notNull(newSection);
        // loop through all current sections, check for same schedule
        sections.forEach(currSection -> currSection.checkForConflict(newSection));
        this.sections.add(newSection);
    }

    Collection<Section> getSections() {
        return new ArrayList<>(sections);
    }

    @Override
    public String toString() {
        return "Student# " + studentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber);
    }
}
