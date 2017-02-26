public class
Fecha {
private int
dia; private
int mes;
private int
anio;
public Fecha(int dia, int mes, int anio) {
this.dia = dia; this.mes = mes; this.anio = anio;
}
public boolean valida ( ) {
if (dia < 1 || dia > 31) return false;
if (mes < 1 || mes > 12) return false;
if (anio < 0) return false;
// determinamos la cantidad de días del mes:
int diasMes = 0;
switch (mes) {
case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12: diasMes = 31;
break;
case 4:
case 6:
case 9:
case 11 : diasMes = 30;
break;
case 2 : // verificación de año bisiesto
if ( (anio % 400 == 0) || ( (anio % 4 == 0) && (anio % 100 != 0)
) )
diasMes = 29;
else
diasMes = 28;
break;
}
if (dia > diasMes) return false;
else return true;
}
public static void main(String[] args)throws IOException {
int dia, mes, anyo;
System.out.println ("Introduce un día: ");
BufferedReader entrada = new BufferedReader(new
InputStreamReader (System.in));
dia = Integer.parseInt(entrada.readLine());
System.out.println ("Introduce un mes: ");
mes = Integer.parseInt(entrada.readLine());
System.out.println ("Introduce un año: ");
anyo = Integer.parseInt(entrada.readLine());
Fecha f1=new Fecha(dia,mes,anyo);
if (f1.valida())
System.out.println("La fecha: "+dia+"/"+mes+"/"+anyo+" es
válida");
else
System.out.println("La fecha: "+dia+"/"+mes+"/"+anyo+"
NO es válida");
}
}
