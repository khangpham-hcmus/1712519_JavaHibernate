package pojo;

public class InformationStudentRegistrated {
    private String studentId;
    private String name;
    private String subjectID;
    private String subjectName;
    private String theoryName;
    private String timeLearning;
    private int shift;

    public InformationStudentRegistrated() {
    }

    public InformationStudentRegistrated(String studentId, String name, String subjectID, String subjectName, String theoryName, String timeLearning, int shift)
    {
        this.studentId = studentId;
        this.name = name;
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.theoryName = theoryName;
        this.timeLearning = timeLearning;
        this.shift = shift;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTheoryName() {
        return theoryName;
    }

    public void setTheoryName(String theoryName) {
        this.theoryName = theoryName;
    }

    public String getTimeLearning() {
        return timeLearning;
    }

    public void setTimeLearning(String timeLearning) {
        this.timeLearning = timeLearning;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getTimeStringShift(int shift)
    {
        switch (shift)
        {
            case 1: return "7h30-9h30";
            case 2: return "9h30-11h30";
            case 3: return "13h30-15h30";
            default: return "15h30-17h30";
        }
    }

    @Override
    public String toString() {
        return "InformationStudentRegistrated{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", subjectID='" + subjectID + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", theoryName='" + theoryName + '\'' +
                ", timeLearning='" + timeLearning + '\'' +
                ", shift=" +this.getTimeStringShift(shift)+" " +
                '}';
    }
}
