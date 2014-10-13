/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablegenerator;

/**
 *
 * @author Nuwan Prabhath
 */
public class Module {
    private String code;
    private String name;
    private int semester;
    private int hours;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public Module(String code, String name, int semester, int hours) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.hours = hours;
    }

   

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
}
