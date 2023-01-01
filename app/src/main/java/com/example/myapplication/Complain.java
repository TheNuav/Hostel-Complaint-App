package com.example.myapplication;

public class Complain {
    public String roomno;
    public String hosteln;
    public String rollno;
    public String complaint;
    public  Complain(){

    }
    public Complain(String rollno,String roomno,String hosteln,String complaint){
        this.complaint=complaint;
        this.hosteln=hosteln;
        this.rollno=rollno;
        this.roomno=roomno;

    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getHosteln() {
        return hosteln;
    }

    public void setHosteln(String hosteln) {
        this.hosteln = hosteln;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}

