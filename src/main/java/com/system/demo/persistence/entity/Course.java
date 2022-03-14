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
@Table(name = "course", catalog = "ucps_system", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseIndex", query = "SELECT c FROM Course c WHERE c.courseIndex = :courseIndex"),
    @NamedQuery(name = "Course.findByCourseIdentifier", query = "SELECT c FROM Course c WHERE c.courseIdentifier = :courseIdentifier"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseAcronym", query = "SELECT c FROM Course c WHERE c.courseAcronym = :courseAcronym"),
    @NamedQuery(name = "Course.findByCourseDescription", query = "SELECT c FROM Course c WHERE c.courseDescription = :courseDescription"),
    @NamedQuery(name = "Course.findByCourseState", query = "SELECT c FROM Course c WHERE c.courseState = :courseState")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "course_index")
    private Integer courseIndex;
    @Basic(optional = false)
    @Column(name = "course_identifier")
    private String courseIdentifier;
    @Basic(optional = false)
    @Column(name = "course_name")
    private String courseName;
    @Basic(optional = false)
    @Column(name = "course_acronym")
    private String courseAcronym;
    @Column(name = "course_description")
    private String courseDescription;
    @Basic(optional = false)
    @Column(name = "course_state")
    private Character courseState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CertificateStudiesDetail> certificateStudiesDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseDetail> courseDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<CourseGroup> courseGroupCollection;
    @OneToMany(mappedBy = "courseEquivalentId")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "course_equivalent_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseEquivalentId;
    @JoinColumn(name = "modulus_id", referencedColumnName = "modulus_id")
    @ManyToOne(optional = false)
    private Modulus modulusId;

    public Course() {
    }

    public Course(Long courseId) {
        this.courseId = courseId;
    }

    public Course(Long courseId, String courseIdentifier, String courseName, String courseAcronym, Character courseState) {
        this.courseId = courseId;
        this.courseIdentifier = courseIdentifier;
        this.courseName = courseName;
        this.courseAcronym = courseAcronym;
        this.courseState = courseState;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(Integer courseIndex) {
        this.courseIndex = courseIndex;
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
    }

    public void setCourseIdentifier(String courseIdentifier) {
        this.courseIdentifier = courseIdentifier;
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

    public Collection<CourseGroup> getCourseGroupCollection() {
        return courseGroupCollection;
    }

    public void setCourseGroupCollection(Collection<CourseGroup> courseGroupCollection) {
        this.courseGroupCollection = courseGroupCollection;
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
