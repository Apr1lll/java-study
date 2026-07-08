package main.java.annotations;

@Print(style = "arrow", color = PrintProcessor.CYAN)
public class Messages {
    
    @Print(style = "hurray", color = PrintProcessor.PURPLE)
    public String happyBirthday() {
        return "С днём рождения!";
    }
    
    @Print(style = "!", color = PrintProcessor.YELLOW)
    public String warning() {
        return "Предупреждение";
    }
    
    public String error() {
        return "Ошибка";
    }
}