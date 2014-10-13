/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablegenerator;

import java.util.ArrayList;

/**
 *
 * @author Dumindu Buddhika
 */
public class Subject {
    
    private String moduleName;
    private String moduleCode;
    private int semester;
    private int duration; //hours
    private ArrayList<String> participants=new ArrayList<String>();

    public Subject(String moduleName, String moduleCode, int semester, int duration) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.semester = semester;
        this.duration = duration;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }
    
    public String toString(){
        return this.moduleName+" : "+this.moduleCode+":"+this.duration+": "+this.semester+"size :"+participants;
                
    }
    
}
