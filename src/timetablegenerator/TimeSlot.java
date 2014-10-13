/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablegenerator;

class TimeSlot {
    
    private int start;
    private Subject subject;
    private int end;

    public TimeSlot(int start, Subject subject) {
        this.start = start;
        this.subject = subject;
        end=start+subject.getDuration();
    }
    
    

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString()
    {
        return start+" "+subject.getModuleName();
    }
    
}
