
public class Date {

    private int day;
    private int month;
    private int year;

    //no se incluye constructor vacio ya que asumimos que una fecha sin informacion dentro es inutil.
    public Date(int dd, int mm, int yyyy) {
        this.day = dd;
        this.month = mm;
        this.year = yyyy;
    }

    //getters y setters
    public void setDay(int d) {
        day = d;
    }
    public void setMonth(int m) {
        month = m;
    }
    public void setYear(int a) {
        year = a;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    /*
    	Valida la fecha y devuelve "true of false" si las condiciones no se cumplen:
    	El dia debe ser menor que 30 o 31 o en caso especial de febrero otro numero.
    	El mes debe ser menor que 12 o 12.
    	El año, dia y mes no pueden ser negativos.
     */
    
    public boolean isCorrectDate() {
        boolean correctDay, correctMonth, correctYear;
        correctYear = year > 0;
        correctMonth = month >= 1 && month <= 12;
        switch (month) {
            case 2:
                if (isLapYear() == true) {
                    correctDay = day >= 1 && day <= 29;
                } else {
                    correctDay = day >= 1 && day <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                correctDay = day >= 1 && day <= 30;
                break;
            default:
                correctDay = day >= 1 && day <= 31;
        }
        return correctDay && correctMonth && correctYear;
    }

    public boolean isLapYear() {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    
    public String isCorrectDateToString(){
    	if (isCorrectDate()==true){
    		return "fecha correcta";
    	} else {
    		return "fecha incorrecta";
    	}
    }

    /* 
		nextDay aumenta el dia por uno, y si este sobrepasa el numero
		maximo que un mes puede tener, aumenta el mes, el validador isCorrectDate
		nos permite tambien comprobar si se han sobrepasado los 12 meses.
    */
    public void nextDay() {
        day++;
        if (isLapYear()== false) {
            day = 1;
            month++;
            if (isCorrectDate()== false) {
                month = 1;
                year++;
            }

        }
    }
    
    /*
    	metodo toString utilizando el String Builder de java, el cual permite
    	crear un string por pasos en vez de coger todas las variables necesarias
    	de antemano, permitiendo asi mas control.
    */
    @Override
    public String toString() {
    	char separator = '/';
        StringBuilder sb = new StringBuilder();
        if (day < 10) {
            sb.append("0");
        }
        sb.append(day);
        sb.append(separator);
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month);
        sb.append(separator);
        sb.append(year);
        return sb.toString();
    }
}