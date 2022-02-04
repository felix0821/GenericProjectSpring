/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.demo.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseIndex", query = "SELECT c FROM Course c WHERE c.courseIndex = :courseIndex"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseAcronym", query = "SELECT c FROM Course c WHERE c.courseAcronym = :courseAcronym"),
    @NamedQuery(name = "Course.findByCourseDescription", query = "SELECT c FROM Course c WHERE c.courseDescription = :courseDescription"),
    @NamedQuery(name = "Course.findByCourseState", query = "SELECT c FROM Course c WHERE c.courseState = :courseState"),
    @NamedQuery(name = "Course.findByCourseTeachingCode", query = "SELECT c FROM Course c WHERE c.courseTeachingCode = :courseTeachingCode")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    @Basic(optional = false)
    @Column(name = "course_index", nullable = false)
    private int courseIndex;
    @Basic(optional = false)
    @Column(name = "course_name", nullable = false, length = 64)
    private String courseName;
    @Basic(optional = false)
    @Column(name = "course_acronym", nullable = false, length = 4)
    private String courseAcronym;
    @Column(name = "course_description", length = 256)
    private String courseDescription;
    @Basic(optional = false)
    @Column(name = "course_state", nullable = false)
    private Character courseState;
    @Basic(optional = false)
    @Column(name = "course_teaching_code", nullable = false)
    private long courseTeachingCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CertificateStudiesDetail> certificateStudiesDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseDetail> courseDetailCollection;
    @OneToMany(mappedBy = "courseEquivalentId")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "course_equivalent_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseEquivalentId;
    @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id", nullable = false)
    @ManyToOne(optional = false)
    private Modulus modulusId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    @ManyToOne(optional = false)
    private Program programId;

    public Course() {
    }

    public Course(Long courseId) {
        this.courseId = courseId;
    }

    public Course(Long courseId, int courseIndex, String courseName, String courseAcronym, Character courseState, long courseTeachingCode) {
        this.courseId = courseId;
        this.courseIndex = courseIndex;
        this.courseName = courseName;
        this.courseAcronym = courseAcronym;
        this.courseState = courseState;
        this.courseTeachingCode = courseTeachingCode;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(int courseIndex) {
        this.courseIndex = courseIndex;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAcronym() {
        return courseAcronym;
    }

    public void setCourseAcronym(String courseAcronym) {
        this.courseAcronym = courseAcronym;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Character getCourseState() {
        return courseState;
    }

    public void setCourseState(Character courseState) {
        this.courseState = courseState;
    }

    public long getCourseTeachingCode() {
        return courseTeachingCode;
    }

    public void setCourseTeachingCode(long courseTeachingCode) {
        this.courseTeachingCode = courseTeachingCode;
    }

    public Collection<CertificateStudiesDetail> getCertificateStudiesDetailCollection() {
        return certificateStudiesDetailCollection;
    }

    public void setCertificateStudiesDetailCollection(Collection<CertificateStudiesDetail> certificateStudiesDetailCollection) {
        this.certificateStudiesDetailCollection = certificateStudiesDetailCollection;
    }

    public Collection<CourseDetail> getCourseDetailCollection() {
        return courseDetailCollection;
    }

    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Course getCourseEquivalentId() {
        return courseEquivalentId;
    }

    public void setCourseEquivalentId(Course courseEquivalentId) {
        this.courseEquivalentId = courseEquivalentId;
    }

    public Modulus getModulusId() {
        return modulusId;
    }

    public void setModulusId(Modulus modulusId) {
        this.modulusId = modulusId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.demo.persistence.entity.Course[ courseId=" + courseId + " ]";
    }
    
}
